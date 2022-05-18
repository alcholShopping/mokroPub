package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ConsumerDao;
import dao.InquiryDao;
import vo.Inquiry;
import vo.Notice;

@WebServlet("/insertInquiryController")
public class InsertInquiryController extends HttpServlet {
	private InquiryDao inquiryDao = new InquiryDao();
	private ConsumerDao consumerDao = new ConsumerDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 상태 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(sessionMemberId == null) {
			// 로그인이 되어있지 않으면
			response.sendRedirect(request.getContextPath()+"/loginController"); // 초기화면으로
			return;
		}	
		request.getRequestDispatcher("/WEB-INF/view/community/inquiry/insertInquiry.jsp").forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 상태 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		if(sessionMemberId == null) {
			// 로그인이 되어있지 않으면
			response.sendRedirect(request.getContextPath()+"/indexController"); // 초기화면으로
		}
		request.setCharacterEncoding("utf-8"); // utf-8 인코딩
		
		String path = request.getServletContext().getRealPath("images/");
		System.out.println(path + " <-- path doPost() insertInquiryController"); 
		
		MultipartRequest multiReq = new MultipartRequest(request, path, 1024*1024*100, "utf-8", new DefaultFileRenamePolicy());

		String title = multiReq.getParameter("title");
		String category = multiReq.getParameter("category");
		String content = multiReq.getParameter("content");
		String pictureOriginalName = multiReq.getOriginalFileName("photo"); // 파일 업로드시 원본의 이름		
		// 사진이 없을 때
		String pictureType = "fileX";
		if(multiReq.getContentType("photo") != null) {
			pictureType = multiReq.getContentType("photo");
		}
		String pictureName = "fileX"; 
		if(multiReq.getContentType("photo") != null) { 
			pictureName = multiReq.getFilesystemName("photo");
		}
		String status = "미답변";
		int consumerNo = consumerDao.changeConsumerIdToNo(sessionMemberId);
		
		//디버깅
		System.out.println(title + " <-- title doPost() insertInquiryController");
		System.out.println(category + " <-- category doPost() insertInquiryController ");
		System.out.println(content + " <-- content doPost() insertInquiryController ");
		System.out.println(pictureOriginalName + " <-- photoOriginalName doPost() insertInquiryController ");
		System.out.println(pictureName + " <-- photoName doPost() insertInquiryController ");
		System.out.println(pictureType + " <-- photoType doPost() insertInquiryController ");
		System.out.println(path + " <-- path doPost() insertInquiryController ");
		System.out.println(status + " <-- status doPost() insertInquiryController ");
		
		Inquiry inquiry = new Inquiry();
		inquiry.setConsumerNo(consumerNo);
		inquiry.setTitle(title);
		inquiry.setCategory(category);
		inquiry.setContent(content);
		inquiry.setStatus(status);
		
		System.out.println(inquiry.getConsumerNo() + " <-- inquiry.getConsumerNo() doPost() insertInquiryController");
		System.out.println(inquiry.getTitle() + " <-- inquiry.getTitle() doPost() insertInquiryController ");
		System.out.println(inquiry.getCategory() + " <-- inquiry.getCategory() doPost() insertInquiryController");
		System.out.println(inquiry.getContent() + " <-- inquiry.getContent() doPost() insertInquiryController ");
		System.out.println(inquiry.getStatus() + " <-- inquiry.getStatus() doPost() insertInquiryController ");
		System.out.println(inquiry.getPhoto() + " <-- inquiry.getPhoto() doPost() insertInquiryController ");
		
		// 파일업로드의 경우 100mbyte 이하의 image/gif, image/png, image/jpeg 3가지 이미지만  허용
		if(pictureType.equals("image/gif") || pictureType.equals("image/png") || pictureType.equals("image/jpeg") ) {
			System.out.println("사진 입력 doPost() insertInquiryController");
			inquiry.setPhoto(pictureName);
			inquiryDao.insertInquiry(inquiry);
		} else if (pictureType.equals("fileX")) {
			System.out.println("이미지 안들어왔을때");
			inquiry.setPhoto(pictureName);
			inquiryDao.insertInquiry(inquiry);
		} else {
			System.out.println("이미지파일만 업로드!");
			File file = new File(path+"\\"+pictureName); // 잘못된 파일을 불러온다. java.io.File  
			file.delete(); // 잘못 업로드된 파일을 삭제
		}
		response.sendRedirect(request.getContextPath()+"/inquiryListController");
		
	}
}
