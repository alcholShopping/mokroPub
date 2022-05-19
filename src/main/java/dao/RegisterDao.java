package dao;

import vo.*;
import java.util.*;

import util.DBUtil;

import java.sql.*;

public class RegisterDao {

	// 회원가입
	public int registerByCustomer(Consumer consumer){
		int row = 99;
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO consumer(consumer_id, PASSWORD, NAME, phone, email, zipcode, address, detailed_Address, consumer_level, adult_certification, resident_number, ACCOUNT, create_date, update_date, pw_update_date)"
				+ " VALUE(?, PASSWORD(?), ?, ?, ?, ?, ? ,?, 0, ?, ?, ?, NOW(), NOW(), NOW());";
		
		conn = DBUtil.getConnection();		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, consumer.getConsumerId());
			stmt.setString(2, consumer.getPassword());
			stmt.setString(3, consumer.getName());
			stmt.setString(4, consumer.getPhone());
			stmt.setString(5, consumer.getEmail());
			stmt.setString(6, consumer.getZipcode());
			stmt.setString(7, consumer.getAddress());
			stmt.setString(8, consumer.getDetailedAddr());
			stmt.setString(9, "Y");
			stmt.setString(10, consumer.getResidentNumber());
			stmt.setString(11, consumer.getAccount());			
			row = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return row;		
	}
	
	// 주소찾는 메서드
	public List<Map<String, Object>> selectAddressListBySearch(String searchAddr){
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();	
		/*
		 SELECT address_no, CONCAT(country," ",city," ",town," ",road_name) AS searchAddr, zipcode 
			FROM address
			WHERE CONCAT(country," ",city," ",town," ",road_name) LIKE ?;
		 */
		System.out.println(searchAddr + " <-- searchAddr selectAddressListBySearch() RegisterDao");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT address_no, CONCAT(province,\" \",city,\" \",town,\" \",street) searchAddr,zipcode FROM address WHERE CONCAT(province,\" \",city,\" \",town,\" \",street) LIKE ?";
			conn = DBUtil.getConnection();
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+searchAddr+"%");
				rs = stmt.executeQuery();
				while(rs.next()) {
					Map<String, Object> m = new HashMap<>();
					m.put("id", rs.getInt("address_no"));
					m.put("searchAddr", rs.getString("searchAddr"));
					m.put("zipcode", rs.getString("zipcode"));
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
		System.out.println(list + " <-- list selectAddressListBySearch() RegisterDao");				
		return list;
	}
	
}
