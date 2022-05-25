package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.Consumer;
import vo.Password;

public class ConsumerDao {
	// consumerOne의 회원정보를 보여주는 메서드
	public List<Consumer> selectConsumerOneInfo(String sessionMemberId){
		List<Consumer> list = new ArrayList<>();
		Consumer consumer = null;	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// consumerId, name, phone, email, address, detailedAddress, consumerLevel, adultCertification, account, createDate를 가져옴
		String sql = " SELECT consumer_id consumerId, NAME, phone, email, address, detailed_Address detailedAddress, consumer_level consumerLevel, ACCOUNT, create_date createDate, update_date updateDate, pw_update_date pwUpdateDate "
				+ " FROM consumer WHERE consumer_id = ?  ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, sessionMemberId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				consumer = new Consumer();
				consumer.setConsumerId(rs.getString("consumerId"));
				consumer.setName(rs.getString("name"));
				consumer.setPhone(rs.getString("phone"));
				consumer.setEmail(rs.getString("email"));
				consumer.setAddress(rs.getString("address"));
				consumer.setDetailedAddr(rs.getString("detailedAddress"));
				consumer.setConsumerLevel(rs.getInt("consumerLevel"));
				consumer.setAccount(rs.getString("account"));
				consumer.setCreateDate(rs.getString("createDate"));
				consumer.setUpdateDate(rs.getString("updateDate"));
				consumer.setPwUpdateDate(rs.getString("pwUpdateDate"));
				
				// 디버깅
				System.out.println(consumer.getConsumerId() + " <-- consumerId selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getName() + " <-- name selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getPhone() + " <-- phone selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getEmail() + " <-- email selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getAddress() + " <-- address selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getDetailedAddr() + " <-- detailedAddress selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getConsumerLevel() + " <-- consumerLevel selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getAccount() + " <-- ACCOUNT selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getCreateDate() + " <-- createDate selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getUpdateDate() + " <-- getUpdateDate selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getPwUpdateDate() + " <-- getPwUpdateDate selectConsumerOneInfo() ConsumerDao ");
				list.add(consumer);
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
	
	// checkConsumerPw에서 받아온 pw를 DB값과 비교하는 메서드
	public String checkConsumerPw(String sessionMemberId){
    String consumerPw = "";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
	    
	String sql = " SELECT password FROM consumer WHERE consumer_id = ? ";
	      
	try {
		conn = DBUtil.getConnection();
	    stmt = conn.prepareStatement(sql);
	    stmt.setString(1, sessionMemberId);
	    rs = stmt.executeQuery();
	    if(rs.next()) {
	    consumerPw = rs.getString("password");
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
		return consumerPw;
	 }

	// UpdateConsumerInfo -> 수정하는 메서드
	public void updateConsumerInfo(Consumer c) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
					
		// consumer_id, password, name, phone, email, address, Detailed_Addreess, Account, UPDATE_DATE
		String sql = " UPDATE consumer SET name = ?, phone = ?, email = ?, address = ?, detailed_Address = ?, account = ?, update_Date = NOW() "
				+ " WHERE consumer_id = ? ";
		// DB값 요청
		// DB에 저장하고 나서 controller에서 받은 jsp값을 받은 값을 DB에 요청 그리고 저장
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getPhone());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getAddress());
			stmt.setString(5, c.getDetailedAddr());
			stmt.setString(6, c.getAccount());
			stmt.setString(7, c.getConsumerId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	// 사용자아이디를 숫자로 변경
	public int changeConsumerIdToNo(String sessionMemberId) {
		int consumerId = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// productNo, count, sessionMemberId에 따라서 cart 추가 
		String sql= "SELECT consumer_no consumerNo FROM consumer WHERE consumer_id = ? ";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, sessionMemberId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				consumerId = rs.getInt("consumerNo");
				System.out.println(consumerId + " <-- consumerId changeConsumerIdToNo() ConsumerDao");
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
		return consumerId;
	}
	
	// 비밀번호 사용기간을 나타내주는 메서드
	public int UsingPwPeriod(String sessionMemberId, String PwUpdateDate) {
		int period = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// productNo, count, sessionMemberId에 따라서 cart 추가 
		String sql= " SELECT TIMESTAMPDIFF(MONTH, ?, NOW()) period FROM consumer WHERE consumer_id = ?  ";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, PwUpdateDate);
			stmt.setString(2, sessionMemberId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				period = rs.getInt("period");
				System.out.println(period + " <-- period UsingPwPeriod() ConsumerDao");
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
		return period;
	}
	
	// 비밀번호 중복 확인 메서드
	public String checkPwOverlap(int consumerNo, String changePw){
		String checkOverlap = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT password FROM password WHERE consumer_no = ? AND password = PASSWORD(?) ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, consumerNo);
			stmt.setString(2, changePw);
			rs = stmt.executeQuery();
			while(rs.next()) {
				checkOverlap = rs.getString("password");		
				System.out.println(checkOverlap + "<-- checkOverlap checkPwOverlap() consumerDao"); // 디버깅
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
		return checkOverlap;
	}


	   // 회원탈되
	   public void deleteConsumer(int consumerId) {
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   String sql = "DELETE FROM consumer where consumer_no = ?";
		   int row = 0;
		   try {
			   conn = DBUtil.getConnection();
			   stmt = conn.prepareStatement(sql);
			   stmt.setInt(1, consumerId);
			   rs = stmt.executeQuery();
		     } catch (Exception e) {
		        e.printStackTrace();
		     } finally {
		        try {
		           rs.close();
		           stmt.close();
		           conn.close();
		        } catch (Exception e) {
		           e.printStackTrace();
		        }
		     }
		  
	   }
	   
}
