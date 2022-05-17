package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.DBUtil;
import vo.Notice;

public class NoticeDao {
	// 공지사항 리스트들을 보여주는 메서드
	public List<Map<String,Object>> selectNoticeList(int beginRow, int rowPerPage){
		List<Map<String,Object>> list = new ArrayList<>( );
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT c.consumer_id consumerId, notice_no noticeNo, title, n.create_date createDate FROM notice n INNER JOIN consumer c ON n.consumer_no = c.consumer_no ORDER BY n.update_date DESC LIMIT ?,? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("consumerId", rs.getString("consumerId"));
				m.put("noticeNo", rs.getInt("noticeNo"));
				m.put("title", rs.getString("title"));
				m.put("createDate", rs.getString("createDate"));
				// 디버깅
				System.out.println(m.get("consumerId") + " <-- consumerId selectNoticeList() NoticeDao ");
				System.out.println(m.get("noticeNo") + " <-- noticeNo selectNoticeList() NoticeDao ");
				System.out.println(m.get("title") + " <-- title selectNoticeList() NoticeDao ");
				System.out.println(m.get("createDate") + " <-- createDate selectNoticeList() NoticeDao ");
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}				
		return list;
	}
	
	// noticeOne을 보여주는 메서드
	public List<Map<String,Object>> selectNoticeOne(int noticeNo){
		List<Map<String,Object>> list = new ArrayList<>( );
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT notice_no noticeNo, c.consumer_id consumerId, title, content, photo, n.create_date createDate, n.update_date updateDate FROM notice n INNER JOIN consumer c ON n.consumer_no = c.consumer_no WHERE notice_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, noticeNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("consumerId", rs.getString("consumerId"));
				m.put("noticeNo", rs.getInt("noticeNo"));
				m.put("title", rs.getString("title"));
				m.put("content", rs.getString("content"));
				m.put("photo", rs.getString("photo"));
				m.put("createDate", rs.getString("createDate"));
				m.put("updateDate", rs.getString("updateDate"));
				// 디버깅
				System.out.println(m.get("consumerId") + " <-- consumerId selectNoticeOne() NoticeDao ");
				System.out.println(m.get("noticeNo") + " <-- noticeNo selectNoticeOne() NoticeDao ");
				System.out.println(m.get("title") + " <-- title selectNoticeOne() NoticeDao ");
				System.out.println(m.get("content") + " <-- content selectNoticeOne() NoticeDao ");
				System.out.println(m.get("photo") + " <-- photo selectNoticeOne() NoticeDao ");
				System.out.println(m.get("createDate") + " <-- createDate selectNoticeOne() NoticeDao ");
				System.out.println(m.get("updateDate") + " <-- updateDate selectNoticeOne() NoticeDao ");
				list.add(m);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}				
		return list;
	}
	
	// notice를 등록하는 메서드
	public void insertNotice(Notice notice) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " INSERT INTO notice (consumer_no, title, content, photo, create_date, update_date) VALUE(?,?,?,?,NOW(),NOW()) ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, notice.getConsumerNo());
			stmt.setString(2, notice.getTitle());
			stmt.setString(3, notice.getContent());
			stmt.setString(4, notice.getPhoto());
			// 디버깅
			int row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void deleteNotice(int noticeNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " DELETE FROM notice WHERE notice_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, noticeNo);
			// 디버깅
			int row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}	
	
	// notice를 업데이트
	public void updateNotice(Notice notice) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " UPDATE notice SET title = ?, content = ?, photo = ?, update_date = NOW() WHERE notice_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, notice.getTitle());
			stmt.setString(2, notice.getContent());
			stmt.setString(3, notice.getPhoto());
			stmt.setInt(4, notice.getNoticeNo());
			// 디버깅
			int row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	// notice totalCount구하기
	public int selectNoticeTotal(){
		int total = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		String sql=" SELECT COUNT(*) cnt FROM notice ";
	try {
		conn = DBUtil.getConnection();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()) {
			total = rs.getInt("cnt");
			System.out.println(total + " <-- total selectNoticeTotal() noticeDao"); // 디버깅
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
		return total;
	}
	
}
