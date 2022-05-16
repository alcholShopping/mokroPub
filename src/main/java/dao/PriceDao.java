package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.Product;

public class PriceDao {
	public List<Product> seleselectPriceByPageAsc(int startPrice,int endPrice,int beginRow,int rowPerPage){
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product product = null;
		String sql = "SELECT product_no productNo,name,price,volume,alcohol_level alcoholLevel,picture FROM product WHERE price between ? and ? ORDER BY price asc LIMIT ?,?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mokroPub","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, startPrice);
			stmt.setInt(2, endPrice);
			stmt.setInt(3, beginRow);
			stmt.setInt(4, rowPerPage);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				product = new Product();
				product.setProductNo(rs.getInt("productNo"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setVolume(rs.getInt("volume"));
				product.setAlcoholLevel(rs.getInt("alcoholLevel"));
				product.setPicture(rs.getString("picture"));
				list.add(product);
				
				//----------------------------�뵒踰꾧퉭--------------------------
				/*
				System.out.println(product.getProductNo());
				System.out.println(product.getName());
				System.out.println(product.getPrice());
				System.out.println(product.getVolume());
				System.out.println(product.getAlcoholLevel());
				System.out.println(product.getPicture());
				*/
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				
			}
		}
		System.out.println(list+"----------------------");
		return list;
	}
	public List<Product> seleselectPriceByPageDesc(int startPrice,int endPrice,int beginRow,int rowPerPage){
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product product = null;
		String sql = "SELECT product_no productNo,name,price,volume,alcohol_level alcoholLevel,picture FROM product WHERE price between ? and ? ORDER BY price desc LIMIT ? ,?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mokroPub","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, startPrice);
			stmt.setInt(2, endPrice);
			stmt.setInt(3, beginRow);
			stmt.setInt(4, rowPerPage);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				product = new Product();
				product.setProductNo(rs.getInt("productNo"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setVolume(rs.getInt("volume"));
				product.setAlcoholLevel(rs.getInt("alcoholLevel"));
				product.setPicture(rs.getString("picture"));
				list.add(product);
				
				//----------------------------�뵒踰꾧퉭--------------------------
				/*
				System.out.println(product.getProductNo());
				System.out.println(product.getName());
				System.out.println(product.getPrice());
				System.out.println(product.getVolume());
				System.out.println(product.getAlcoholLevel());
				System.out.println(product.getPicture());
				*/
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				
			}
		}
		return list;
	}
	public int selectPriceTotal(int startPrice,int endPrice){
		int total = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		// startPrice와 endPrice 사이의 가격대 상품의 총 갯수
		String sql=" SELECT COUNT(*) cnt FROM product WHERE price between ? and ? ";
	try {
		conn = DBUtil.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, startPrice);
		stmt.setInt(2, endPrice);
		rs = stmt.executeQuery();
		while(rs.next()) {
			total = rs.getInt("cnt");
			//----------------------- �뵒踰꾧퉭--------------------------
			System.out.println(total + " <-- total selectPriceTotal() priceDao");
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
