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
import dao.NoticeDao;
import vo.Notice;

@WebServlet("/updateNoticeController")
public class UpdateNoticeController extends HttpServlet {
	private ConsumerDao consumerDao = new ConsumerDao();
	private NoticeDao noticeDao = new NoticeDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// admin 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		String accessId = "admin";
		System.out.println(sessionMemberId + " <-- sessoinMemberId doGet() insertNoticeController");
		if( (sessionMemberId == null) || (!sessionMemberId.equals(accessId)) ) {
			// sessionMemberId가 admin이 아니면 noticeListController로 이동
			System.out.println(sessionMemberId + " <-- sessoinMemberId doGet() insertNoticeController");
			response.sendRedirect(request.getContextPath()+"/noticeListController");
			return;
		}		
		// noticeOne.jsp에서 값 받아오기
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		System.out.println(noticeNo + " <-- noticeNo doGet() updateNoticeController");

		List<Map<String,Object>> noticeOneList = noticeDao.selectNoticeOne(noticeNo);
		for(Map m : noticeOneList) {
			System.out.println(m.get("consumerId") + " <-- consumerId doGet() updateNoticeController ");
			System.out.println(m.get("noticeNo") + " <-- noticeNo doGet() updateNoticeController ");
			System.out.println(m.get("title") + " <-- title doGet() updateNoticeController ");
			System.out.println(m.get("content") + " <-- content doGet() updateNoticeController ");
			System.out.println(m.get("photo") + " <-- photo doGet() updateNoticeController ");
			System.out.println(m.get("createDate") + " <-- createDate doGet() updateNoticeController ");
			System.out.println(m.get("updateDate") + " <-- updateDate doGet() updateNoticeController ");
		}
		request.setAttribute("noticeOneList", noticeOneList);	
		request.getRequestDispatcher("/WEB-INF/view/community/notice/updateNotice.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// admin 확인
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		String accessId = "admin";
		System.out.println(sessionMemberId + " <-- sessoinMemberId doPost() insertNoticeController");
		if( (sessionMemberId == null) || (!sessionMemberId.equals(accessId)) ) {
			// sessionMemberId가 admin이 아니면 noticeListController로 이동
			System.out.println(sessionMemberId + " <-- sessoinMemberId doPost() insertNoticeController");
			response.sendRedirect(request.getContextPath()+"/noticeListController");
			return;
		}		
		request.setCharacterEncoding("utf-8"); // utf-8 인코딩
		
		String path = request.getServletContext().getRealPath("images/");
		System.out.println(path + " <-- path doPost() insertNoticeController"); 
		
		MultipartRequest multiReq = new MultipartRequest(request, path, 1024*1024*100, "utf-8", new DefaultFileRenamePolicy());

		int noticeNo =  Integer.parseInt(multiReq.getParameter("noticeNo"));
		String title = multiReq.getParameter("title");
		String content = multiReq.getParameter("content");
		String pictureOriginalName = multiReq.getOriginalFileName("photo"); // 파일 업로드시 원본의 이름
		String pictureName = multiReq.getFilesystemName("photo"); // new DefaultFileRenamePolicy()객체를 통해 변경된 이름
		String pictureType = multiReq.getContentType("photo");
		int consumerNo = consumerDao.changeConsumerIdToNo(sessionMemberId);
		
		//디버깅
		System.out.println(noticeNo + " <-- noticeNo doPost() insertNoticeController");
		System.out.println(title + " <-- title doPost() insertNoticeController");
		System.out.println(content + " <-- content doPost() insertNoticeController ");
		System.out.println(pictureOriginalName + " <-- photoOriginalName doPost() insertNoticeController ");
		System.out.println(pictureName + " <-- photoName doPost() insertNoticeController ");
		System.out.println(pictureType + " <-- photoType doPost() insertNoticeController ");
		System.out.println(path + " <-- path doPost() insertNoticeController ");
		
		Notice notice = new Notice();
		
		// 파일업로드의 경우 100mbyte 이하의 image/gif, image/png, image/jpeg 3가지 이미지만  허용
		if(pictureType.equals("image/gif") || pictureType.equals("image/png") || pictureType.equals("image/jpeg")) {
			System.out.println("사진 입력 doPost() insertNoticeController");
			
			notice.setNoticeNo(noticeNo);
			notice.setConsumerNo(consumerNo);
			notice.setTitle(title);
			notice.setContent(content);
			notice.setPhoto(pictureName);
			
			System.out.println(notice.getNoticeNo() + " <-- notice.getNoticeNo() doPost() insertNoticeController");
			System.out.println(notice.getConsumerNo() + " <-- notice.getConsumerNo() doPost() insertNoticeController");
			System.out.println(notice.getTitle() + " <-- notice.getTitle() doPost() insertNoticeController ");
			System.out.println(notice.getContent() + " <-- notice.getContent() doPost() insertNoticeController ");
			System.out.println(notice.getPhoto() + " <-- notice.getPhoto() doPost() insertNoticeController ");

			noticeDao.updateNotice(notice);
		} else {
			System.out.println("이미지파일만 업로드!");
			File file = new File(path+"\\"+pictureName); // 잘못된 파일을 불러온다. java.io.File  
			file.delete(); // 잘못 업로드된 파일을 삭제
		}
		response.sendRedirect(request.getContextPath()+"/noticeListController");
	}

}
