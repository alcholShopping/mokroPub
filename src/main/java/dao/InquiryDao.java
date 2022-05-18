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
import vo.Inquiry;
import vo.Notice;

public class InquiryDao {
	// 공지사항 리스트들을 보여주는 메서드
	public List<Map<String,Object>> selectInquiryList(int beginRow, int rowPerPage){
		List<Map<String,Object>> list = new ArrayList<>( );
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT inquiry_no inquiryNo, c.consumer_id, title, i.create_date  FROM inquiry i INNER JOIN consumer c ON i.consumer_no = c.consumer_no ORDER BY i.update_date DESC LIMIT ?,?";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, rowPerPage);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("inquiryNo", rs.getInt("inquiryNo"));
				m.put("consumerId", rs.getString("c.consumer_id"));
				m.put("title", rs.getString("title"));
				m.put("createDate", rs.getString("i.create_date"));
				// 디버깅
				System.out.println(m.get("inquiryNo") + " <-- inquiryNo selectInquiryList() InquiryDao ");
				System.out.println(m.get("consumerId") + " <-- consumerId selectInquiryList() InquiryDao ");
				System.out.println(m.get("title") + " <-- title selectInquiryList() InquiryDao ");
				System.out.println(m.get("createDate") + " <-- createDate selectInquiryList() InquiryDao ");
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
	
	// inquiryOne을 보여주는 메서드
	public List<Map<String,Object>> selectInquiryOne(int inquiryNo){
		List<Map<String,Object>> list = new ArrayList<>( );
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT inquiry_no inquiryNo, c.consumer_id, category, title, content, `status`, answer, photo, i.create_date  FROM inquiry i INNER JOIN consumer c ON i.consumer_no = c.consumer_no WHERE inquiry_no = ?";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, inquiryNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("inquiryNo", rs.getString("inquiryNo"));
				m.put("consumerId", rs.getString("c.consumer_id"));
				m.put("category", rs.getString("category"));
				m.put("title", rs.getString("title"));
				m.put("content", rs.getString("content"));
				m.put("status", rs.getString("status"));
				m.put("answer", rs.getString("answer"));
				m.put("photo", rs.getString("photo"));
				m.put("createDate", rs.getString("i.create_date"));
				// 디버깅
				System.out.println(m.get("inquiryNo") + " <-- inquiryNo selectInquiryOne() InquiryDao ");
				System.out.println(m.get("consumerId") + " <-- consumerId selectInquiryOne() InquiryDao ");
				System.out.println(m.get("category") + " <-- category selectInquiryOne() InquiryDao ");
				System.out.println(m.get("title") + " <-- title selectInquiryOne() InquiryDao ");
				System.out.println(m.get("content") + " <-- content selectInquiryOne() InquiryDao ");
				System.out.println(m.get("status") + " <-- status selectInquiryOne() InquiryDao ");
				System.out.println(m.get("answer") + " <-- answer selectInquiryOne() InquiryDao ");
				System.out.println(m.get("photo") + " <-- photo selectInquiryOne() InquiryDao ");
				System.out.println(m.get("createDate") + " <-- createDate selectInquiryOne() InquiryDao ");
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
	
	// inquiry를 등록하는 메서드
	public void insertInquiry(Inquiry inquiry) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " INSERT INTO inquiry (consumer_no, title, category, content, photo, status, create_date, update_date) VALUE(?,?,?,?,?,?,NOW(),NOW()) ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, inquiry.getConsumerNo());
			stmt.setString(2, inquiry.getTitle());
			stmt.setString(3, inquiry.getCategory());
			stmt.setString(4, inquiry.getContent());
			stmt.setString(5, inquiry.getPhoto());
			stmt.setString(6, inquiry.getStatus());
			// 디버깅
			int row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
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
	public void updateInquiry(Inquiry inquiry) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = " UPDATE inquiry SET title = ?, category =?, content = ?, photo = ?, update_date = NOW() WHERE inquiry_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, inquiry.getTitle());
			stmt.setString(2, inquiry.getCategory());
			stmt.setString(3, inquiry.getContent());
			stmt.setString(4, inquiry.getPhoto());
			stmt.setInt(5, inquiry.getInquiryNo());
			// 디버깅
			int row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
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
	
	// inquiry 삭제
	public void deleteInquiry(int inquiryNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " DELETE FROM inquiry WHERE inquiry_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, inquiryNo);
			// 디버깅
			int row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
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
	
	// inquiry totalCount구하기
	public int selectInquiryTotal(){
		int total = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		String sql=" SELECT COUNT(*) cnt FROM inquiry ";
	try {
		conn = DBUtil.getConnection();
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()) {
			total = rs.getInt("cnt");
			System.out.println(total + " <-- total selectInquiryTotal() InquiryDao"); // 디버깅
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
