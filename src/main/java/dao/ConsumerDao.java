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
import vo.Category;
import vo.Consumer;

public class ConsumerDao {
	// consumerOne의 회원정보를 보여주는 메서드
	public List<Consumer> selectConsumerOneInfo(String sessionMemberId){
		List<Consumer> list = new ArrayList<>();
		Consumer consumer = null;	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// consumerId, name, phone, email, address, detailedAddress, consumerLevel, adultCertification, account, createDate를 가져옴
		String sql = " SELECT consumer_id consumerId, NAME, phone, email, address, detailed_Address detailedAddress, consumer_level consumerLevel, ACCOUNT, create_date createDate, update_date updateDate "
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
	      
	      String sql = " SELECT password FROM Consumer WHERE consumer_id = ? ";
	      
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
			String sql = " UPDATE consumer SET password = PASSWORD(?), name = ?, phone = ?, email = ?, address = ?, detailed_Address = ?, account = ?, update_Date = NOW() "
					+ " WHERE consumer_id = ? ";
			// DB값 요청
			// DB에 저장하고 나서 controller에서 받은 jsp값을 받은 값을 DB에 요청 그리고 저장
			try {
				conn = DBUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, c.getPassword());
				stmt.setString(2, c.getName());
				stmt.setString(3, c.getPhone());
				stmt.setString(4, c.getEmail());
				stmt.setString(5, c.getAddress());
				stmt.setString(6, c.getDetailedAddr());
				stmt.setString(7, c.getAccount());
				stmt.setString(8, c.getConsumerId());
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


//	   // 회원탈되
//	   public void deleteConsumer(String sessionMemberId, String pw) {
//		   Connection conn = null;
//		   PreparedStatement stmt = null;
//		   ResultSet rs = null;
//		   String sql = "DELETE FROM consumer where consumer_id = ? AND password = PASSWORD(?) ";
//			
//		   try {
//			   conn = DBUtil.getConnection();
//			   stmt = conn.prepareStatement(sql);
//			   stmt.setString(1, sessionMemberId);
//			   rs = stmt.executeQuery();
//		       int row = stmt.executeUpdate();  
//		     } catch (Exception e) {
//		        e.printStackTrace();
//		     } finally {
//		        try {
//		           rs.close();
//		           stmt.close();
//		           conn.close();
//		        } catch (Exception e) {
//		           e.printStackTrace();
//		        }
//		     }
//	   }
	   
}
