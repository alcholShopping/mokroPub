package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

@WebServlet("/updateInquiryController")
public class UpdateInquiryController extends HttpServlet {
	private InquiryDao inquiryDao = new InquiryDao();
	private ConsumerDao consumerDao = new ConsumerDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		// inquiryOne.jsp에서 값 받아오기
		int inquiryNo = Integer.parseInt(request.getParameter("inquiryNo"));
		String accessId = request.getParameter("consumerId");		
		// 디버깅
		System.out.println(accessId + " <-- sessoinMemberId doGet() updateInquiryController");
		System.out.println(sessionMemberId + " <-- sessoinMemberId doGet() updateInquiryController");
		System.out.println(inquiryNo + " <-- inquiryNo doGet() updateInquiryController");
		
		if( (sessionMemberId == null) || (!sessionMemberId.equals(accessId)) ) {
			// sessionMemberId가 글쓴이가 아니고 비로그인상태면 loginController로 이동
			response.sendRedirect(request.getContextPath()+"/loginController");
			return;
		}		

		List<Map<String,Object>> inquiryOneList = inquiryDao.selectInquiryOne(inquiryNo);
		for(Map m : inquiryOneList) {
			System.out.println(m.get("inquiryNo") + " <-- inquiryNo doGet() updateInquiryController ");
			System.out.println(m.get("consumerId") + " <-- consumerId doGet() updateInquiryController ");
			System.out.println(m.get("category") + " <-- category doGet() updateInquiryController ");
			System.out.println(m.get("title") + " <-- title doGet() updateInquiryController ");
			System.out.println(m.get("content") + " <-- content doGet() updateInquiryController ");
			System.out.println(m.get("status") + " <-- status doGet() updateInquiryController ");
			System.out.println(m.get("answer") + " <-- answer doGet() updateInquiryController ");
			System.out.println(m.get("photo") + " <-- photo doGet() updateInquiryController ");
			System.out.println(m.get("createDate") + " <-- createDate doGet() updateInquiryController ");
			System.out.println(m.get("updateDate") + " <-- updateDate doGet() updateInquiryController ");
		}
		request.setAttribute("inquiryOneList", inquiryOneList);	
		request.getRequestDispatcher("/WEB-INF/view/community/inquiry/updateInquiry.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		
		String path = request.getServletContext().getRealPath("images/");
		System.out.println(path + " <-- path doPost() updateInquiryController"); 		
		MultipartRequest multiReq = new MultipartRequest(request, path, 1024*1024*100, "utf-8", new DefaultFileRenamePolicy());		
		// updateInquiry.jsp에서 값 받아오기
		int inquiryNo = Integer.parseInt(multiReq.getParameter("inquiryNo"));
		String accessId = multiReq.getParameter("consumerId");
		// 디버깅
		System.out.println(accessId + " <-- sessoinMemberId doGet() updateInquiryController");
		System.out.println(sessionMemberId + " <-- sessoinMemberId doGet() updateInquiryController");
		System.out.println(inquiryNo + " <-- inquiryNo doGet() updateInquiryController");
		
		if( (sessionMemberId == null) || (!sessionMemberId.equals(accessId)) ) {
			// sessionMemberId가 글쓴이가 아니고 비로그인상태면 loginController로 이동
			response.sendRedirect(request.getContextPath()+"/loginController");
			return;
		}
		
		request.setCharacterEncoding("utf-8"); // utf-8 인코딩
		

		String title = multiReq.getParameter("title");
		String category = multiReq.getParameter("category");
		String content = multiReq.getParameter("content");
		String pictureOriginalName = multiReq.getOriginalFileName("photo"); // 파일 업로드시 원본의 이름
		String pictureName = multiReq.getFilesystemName("photo"); // new DefaultFileRenamePolicy()객체를 통해 변경된 이름
		String pictureType = multiReq.getContentType("photo");
		int consumerNo = consumerDao.changeConsumerIdToNo(sessionMemberId);
		
		//디버깅
		System.out.println(title + " <-- title doPost() updateInquiryController");
		System.out.println(category + " <-- category doPost() updateInquiryController ");
		System.out.println(content + " <-- content doPost() updateInquiryController ");
		System.out.println(pictureOriginalName + " <-- photoOriginalName doPost() updateInquiryController ");
		System.out.println(pictureName + " <-- photoName doPost() updateInquiryController ");
		System.out.println(pictureType + " <-- photoType doPost() updateInquiryController ");
		System.out.println(path + " <-- path doPost() updateInquiryController ");
		
		Inquiry inquiry = new Inquiry();
		
		// 파일업로드의 경우 100mbyte 이하의 image/gif, image/png, image/jpeg 3가지 이미지만  허용
		if(pictureType.equals("image/gif") || pictureType.equals("image/png") || pictureType.equals("image/jpeg")) {
			System.out.println("사진 입력 doPost() insertInquiryController");
			
			inquiry.setInquiryNo(inquiryNo);
			inquiry.setConsumerNo(consumerNo);
			inquiry.setTitle(title);
			inquiry.setCategory(category);
			inquiry.setContent(content);
			inquiry.setPhoto(pictureName);
			
			System.out.println(inquiry.getConsumerNo() + " <-- inquiry.getConsumerNo() doPost() updateInquiryController");
			System.out.println(inquiry.getTitle() + " <-- inquiry.getTitle() doPost() updateInquiryController ");
			System.out.println(inquiry.getCategory() + " <-- inquiry.getCategory() doPost() updateInquiryController");
			System.out.println(inquiry.getContent() + " <-- inquiry.getContent() doPost() updateInquiryController ");
			System.out.println(inquiry.getPhoto() + " <-- inquiry.getPhoto() doPost() updateInquiryController ");

			inquiryDao.updateInquiry(inquiry);
		
		} else {
			System.out.println("이미지파일만 업로드!");
			File file = new File(path+"\\"+pictureName); // 잘못된 파일을 불러온다. java.io.File  
			file.delete(); // 잘못 업로드된 파일을 삭제
		}	
		
		response.sendRedirect(request.getContextPath()+"/inquiryListController");		
	}

}
