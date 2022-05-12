package dao;

import vo.*;
import java.util.*;
import java.sql.*;

public class RegisterDao {

	// 소비자 회원가입
	public int registerByCustomer(Customer customer) throws Exception {
		int row = 99;
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mokropub","root","java1234");
		PreparedStatement stmt = null;

		
		
		String sql = "INSERT INTO consumer(consumer_id, PASSWORD, NAME, phone, email, zipcode, address, detailed_Address, consumer_level, adult_certification, resident_number, ACCOUNT, create_date, update_date)"
				+ " VALUES(?, PASSWORD(?), ?, ?, ?, ?, ? ,?, 0, ?, ?, ?, NOW(), NOW());";
		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, customer.getConsumerId());
		stmt.setString(2, customer.getPassword());
		stmt.setString(3, customer.getName());
		stmt.setString(4, customer.getPhone());
		stmt.setString(5, customer.getEmail());
		stmt.setString(6, customer.getZipCode());
		stmt.setString(7, customer.getAddress());
		stmt.setString(8, customer.getDetailedAddress());
		stmt.setString(9, "Y");
		stmt.setString(10, customer.getResidentNumber());
		stmt.setString(11, customer.getAccountNumber());
		
		row = stmt.executeUpdate();
		
		conn.close();
		stmt.close();
		return row;
		
	}
	
	public List<Map<String, Object>> selectAddressListBySearch(String searchAddr) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		/*
		 SELECT address_no, CONCAT(country," ",city," ",town," ",road_name) AS searchAddr, zipcode 
			FROM address
			WHERE CONCAT(country," ",city," ",town," ",road_name) LIKE ?;
		 */
		
		System.out.println(searchAddr+"<<<<<<<<<<받아온 주소");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT address_no, CONCAT(country,\" \",city,\" \",town,\" \",road_name) AS searchAddr, zipcode FROM address WHERE CONCAT(country,\" \",city,\" \",town,\" \",road_name) LIKE ?";
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mokropub","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+searchAddr+"%");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("id", rs.getInt("address_no"));
				m.put("addr", rs.getString("searchAddr"));
				m.put("zipcode", rs.getString("zipcode"));
				list.add(m); 
			}
			System.out.println(list+"<------------list");
				conn.close();
				stmt.close();
				rs.close();
				
		return list;
	}
}
