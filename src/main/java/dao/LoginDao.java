package dao;

import vo.*;
import java.util.*;

import util.DBUtil;

import java.sql.*;

public class LoginDao {
	// consumerId를 가져오는 메서드
	public String selectMemberByIdPw(String id, String pw){
		String memberId = null;
		Consumer consumer = null;
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT consumer_id consumerId FROM consumer WHERE consumer_id= ? AND password = PASSWORD(?)";

        try {
        	conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs  = stmt.executeQuery();
			while(rs.next()) {
				consumer = new Consumer();
				consumer.setConsumerId(rs.getString("consumerId"));
				memberId = consumer.getConsumerId();
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
        System.out.println(memberId + " <-- memberId selectMemberByIdPw() LoginDao");
		return memberId;
	}
	
	// 일반 비밀번호를 복호화된 비밀번호로 가져오는 메서드
	public String changePwToEncryptionPw(String sessionMemberId, String pw) {
		String password = "";
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;       
        String sql = "SELECT password FROM consumer WHERE consumer_id = ? AND password = PASSWORD(?) ";

        try {
        	conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, sessionMemberId);
			stmt.setString(2, pw);
			rs  = stmt.executeQuery();
			if(rs.next()) {
				password = rs.getString("password");
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
        System.out.println(password + " <-- password changePwToencryptionPw() LoginDao");
		return password;
	}
	
	//
	// 비밀번호 변경과 비밀번호 마지막 변경 날짜 업데이트
    public void UpdateConsumerPwAndDate(int consumerId,String updatePw ) {
       int row = 0;
       Connection conn = null;
       PreparedStatement stmt = null;
       // 비밀번호와 날짜를 업데이트
       String sql=" UPDATE consumer SET "
             + " password = PASSWORD( ? ) "
             + " , pw_update_date = NOW()  "
             + " WHERE consumer_no= ?";
       try {
          conn = DBUtil.getConnection();
          stmt = conn.prepareStatement(sql);
          stmt.setString (1, updatePw);
          stmt.setInt(2, consumerId );
          
          row = stmt.executeUpdate();
          if(row == 1) {
             System.out.println("비밀번호 변경 성공");
          } else {
             System.out.println("비밀번호 변경 실패 ");
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
   
    // 비밀번호 변경 후 password 테이블에 마지막 변경 내역 추가하기 
    public void insertPasswordAndDate(int consumerId,String updatePw) {
       int row = 0;
       Connection conn = null;
       PreparedStatement stmt = null;
       ResultSet rs = null; 

       // productNo, count, sessionMemberId에 따라서 cart 추가 
       String sql=" INSERT INTO password VALUE(?, password(?),NOW()) ";
      
       try {
          conn = DBUtil.getConnection();
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, consumerId);
          stmt.setString(2, updatePw);
          row = stmt.executeUpdate();
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


}
