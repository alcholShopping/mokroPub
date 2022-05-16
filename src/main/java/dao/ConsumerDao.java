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
	   public List<Consumer>updateConsumerInfo(String sessionMemberId) {
	      List<Consumer> list = new ArrayList<>();
	      Consumer consumer = null;   
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      int row = -1;
	      
	      // consumer_id, password, name, phone, email, address, Detailed_Addreess, Account, UPDATE_DATE
	      String sql = "UPDATE consumer SET password = PASSWORD(?), name = ?, phone = ?, email = ?, adderss = ?, detailedAddress = ?, account = ?, updateDate = ?,"
	            + " where consumer_id = ?";
	      /*
	      String sql = "UPDATE consumer_id consumerId, password, name, phone, email,  zipcode, address, detailedAddress, account,  UPDATE_DATE updateDate"
	            + "SET consumer_id = ?, password = ?, name = ?, phone = ?, email = ?, zipcode = ?, adderss = ?, detailedAddress = ?, account = ?, updateDate = ?,"
	            + "where consumer_no = ?";
	            
	            */
	      
	      // DB값 요청
	      try {
	         conn = DBUtil.getConnection();
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, consumer.getConsumerId());
	         stmt.setString(2, consumer.getPassword());
	         stmt.setString(3, consumer.getName());
	         stmt.setString(4, consumer.getPhone());
	         stmt.setString(5, consumer.getEmail());
	         stmt.setString(6, consumer.getAddress());
	         stmt.setString(7, consumer.getDetailedAddr());
	         stmt.setString(8, consumer.getAccount());
	         stmt.setString(9, consumer.getUpdateDate());
	         stmt.setInt(10, consumer.getConsumerNo());
	         row = stmt.executeUpdate();
	         
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

	      return list;
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
