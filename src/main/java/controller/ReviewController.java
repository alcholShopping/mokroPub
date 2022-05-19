package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.multipart.*;
import com.oreilly.servlet.MultipartRequest;
import java.io.*;
import vo.*;
import dao.*;

@WebServlet("/reviewController")
public class ReviewController extends HttpServlet {
	/* 
	 1. orderedNo를 GET으로 받아옴
	 2. 별점, 제목, 사진을 입력받아서 

	*/
	
	Review rev = null;
	ReviewDao rd = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		
		request.setAttribute("orderNo", orderNo);
		request.getRequestDispatcher("/WEB-INF/view/review/review.jsp").forward(request, response);
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
		String pictureOriginalName = multiReq.getOriginalFileName("picture"); // 파일 업로드시 원본의 이름
		
		int orderNo = Integer.parseInt(multiReq.getParameter("orderNo"));
		int settedStar = Integer.parseInt(multiReq.getParameter("settedStar"));
		String content = multiReq.getParameter("content");

		// 사진이 없을때
		String pictureType = "fileX.jpg";
		if(multiReq.getContentType("picture") != null) {
			pictureType = multiReq.getContentType("picture");
		}
		//request 사용 불가 > multiReq가 다 옮겨받음
		String pictureName = "fileX.jpg"; 
		if(multiReq.getContentType("picture") != null) { // new DefaultFileRenamePolicy()객체를 통해 변경된 이름
			pictureName = multiReq.getFilesystemName("picture");
		}
		
		//디버깅
		System.out.println(pictureOriginalName + " <-- photoOriginalName");
		System.out.println(pictureName + " <-- photoName");
		System.out.println(pictureType + " <-- photoType");
		System.out.println(path + " <-- path");
		
		rev.setOrderNo(orderNo);
		rev.setStar(settedStar);
		rev.setContent(content);
		
		// 파일업로드의 경우 100mbyte 이하의 image/gif, image/png, image/jpeg 3가지 이미지만  허용
		if(pictureType.equals("image/gif") || pictureType.equals("image/png") || pictureType.equals("image/jpeg")) {
			System.out.println("db고고!");
			
			
			rev.setPicture(pictureName);
			
			System.out.println(orderNo + "==========orderNo===============");
			System.out.println(settedStar + "==========settedStar===============");
			System.out.println(content + "==========content===============");
			System.out.println(pictureName + "==========pictureName===============");
			
			rd.InsertReviewByOrderNo(rev);
			

			response.sendRedirect(request.getContextPath()+"/myReviewListController");
		}  
		else if(pictureType.equals("fileX.jpg"))
		{	
			System.out.println("이미지 안들어왔을때");
			rev.setPicture(pictureName);
			rd.InsertReviewByOrderNo(rev);
			
			response.sendRedirect(request.getContextPath()+"/myReviewListController");

		} 	else {
			System.out.println("이미지파일만 업로드!");
			// 잘못들어온 파일이므로 업로드된 파일 지우고 폼으로...이동
			File file = new File(path+"\\"+pictureName); // 잘못된 파일을 불러온다. java.io.File  
			file.delete(); // 잘못 업로드된 파일을 삭제
			request.getRequestDispatcher("/WEB-INF/view/review/review.jsp").forward(request, response);
		
		}
	}

}
