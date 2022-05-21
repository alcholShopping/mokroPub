package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.*;
import vo.*;


@WebServlet("/reviewUpdateController")
public class ReviewUpdateController extends HttpServlet {

	Review rev = null;
	ReviewDao rd = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		System.out.println(orderNo + "<---orderNo doGet ReviewUpdateController");
		rd = new ReviewDao();
		
		Review rev = rd.SelectReviewByOrderNo(reviewNo);
		String pName = rd.SelectProdctNameByReviewNo(reviewNo);
		
		request.setAttribute("pName", pName);
		request.setAttribute("rev", rev);
		request.setAttribute("orderNo", orderNo);
		request.getRequestDispatcher("/WEB-INF/view/review/myReviewUpdateForm.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		rev = new Review();
		rd = new ReviewDao();
		request.setCharacterEncoding("utf-8");

		
		// DefaultFileRenamePolicy rp = new DefaultFileRenamePolicy();
		String path = request.getServletContext().getRealPath("images/");
		System.out.println(path); 
		
		MultipartRequest multiReq = new MultipartRequest(request, path, 1024*1024*100, "utf-8", new DefaultFileRenamePolicy());
		// 2^10 byte = 1 kbyte 1024 byte = 1 kbte
		// 2^10 kbyte = 1 mbyte
		// 100 mbyte = 1024*1024*100 byte = 104857600 byte 곱셈을 계산해서 코딩하면 가독성이 떨어진다.  ex) 24*60*60 하루에 대한 초

		//request 사용 불가 > multiReq가 다 옮겨받음
		String pictureName = "fileX.jpg"; 
		if(multiReq.getContentType("picture") != null) { // new DefaultFileRenamePolicy()객체를 통해 변경된 이름
			pictureName = multiReq.getFilesystemName("picture");
		}
		 
		int settedStar = Integer.parseInt(multiReq.getParameter("settedStar"));
		String content = multiReq.getParameter("content");
		
		// 사진이 안들어갈수도 있잖아?
		String pictureType = "fileX.jpg";
		if(multiReq.getContentType("picture") != null) {
			pictureType = multiReq.getContentType("picture");
		}
		
		int reviewNo = Integer.parseInt(multiReq.getParameter("reviewNo"));
//		
//		//디버깅
		System.out.println(pictureName + " <-- photoName");
		System.out.println(settedStar + " <-- settedStar");
		System.out.println(pictureType + " <-- picturetype");
		System.out.println(content + " <-- content");
		System.out.println(reviewNo + " <-- reviewNo");
		System.out.println(path + " <-- path");

		rev.setReviewNo(reviewNo);
		rev.setStar(settedStar);
		rev.setContent(content);
//		// 파일업로드의 경우 100mbyte 이하의 image/gif, image/png, image/jpeg 3가지 이미지만  허용
		if(pictureType.equals("image/gif") || pictureType.equals("image/png") || pictureType.equals("image/jpeg")) {
			System.out.println("db고고!");
			
			
			rev.setPicture(pictureName);
			
			System.out.println(settedStar + "==========settedStar===============");
			System.out.println(content + "==========content===============");
			System.out.println(pictureName + "==========pictureName===============");
			
			

			
		} else if(pictureType.equals("fileX.jpg")){	
			System.out.println("이미지 안들어왔을때");
			rev.setPicture(pictureName);
			
		} else {
			System.out.println("이미지파일만 업로드!");
			// 잘못들어온 파일이므로 업로드된 파일 지우고 폼으로...이동
			rev.setPicture(pictureName);
			File file = new File(path+"\\"+pictureName); // 잘못된 파일을 불러온다. java.io.File  
			file.delete(); // 잘못 업로드된 파일을 삭제
		}
		
		rd.UpdateReviewByOrderNo(rev);
		
		response.sendRedirect(request.getContextPath() + "/myReviewListController");
	}

}
