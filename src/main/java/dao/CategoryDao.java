package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.Category;
import vo.Product;

public class CategoryDao {
	
	// 카테코리넘버에 따른 카테고리 타입 출력
		public String selectCategoryType(int categoryNo){
			String type = null;
			Category category = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs =null;
			// category에서 category_no에 따른 type을 출력
			String sql=" SELECT TYPE FROM category WHERE category_no = ? ";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, categoryNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				category = new Category();
				category.setType(rs.getString("type"));
				type = category.getType();

				//----------------------- 디버깅--------------------------
				System.out.println(category.getType() + " <-- getType() selectCategoryType() categoryDao");
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
			return type;
		}
		
		// 카테코리에 따른 상품 갯수 출력
		public int selectCategoryTotal(int categoryNo){
			int total = 0;
			Product product = null;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs =null;
			//product에서 category_no에 따른 상품 갯수를 가져옴
			String sql=" SELECT COUNT(*) cnt FROM product WHERE category_no = ? ";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, categoryNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				total = rs.getInt("cnt");
				//----------------------- 디버깅--------------------------
				System.out.println(total + " <-- total selectCategoryTotal() categoryDao");
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
		
	// 카테코리에 따른 상품 리스트 출력
	public List<Product> selectCategoryByPage(int categoryNo, int beginRow, int rowPerPage ){
		List<Product> list = new ArrayList<>();
		Product product = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		//product에서 product_no,name,price,volume,alcohol_level alcoholLevel,picture 가져옴
		String sql=" SELECT product_no productNo, name,price,volume,alcohol_level alcoholLevel,picture "
				+ " FROM product"
				+ " WHERE category_no = ? "
				+ " LIMIT ?,?";
	try {
		conn = DBUtil.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, categoryNo);
		stmt.setInt(2, beginRow);
		stmt.setInt(3, rowPerPage);
		rs = stmt.executeQuery();
		while(rs.next()) {
			product = new Product();
			product.setProductNo(rs.getInt("ProductNo"));
			product.setName(rs.getString("name"));
			product.setPrice(rs.getInt("price"));
			product.setVolume(rs.getInt("volume"));
			product.setAlcoholLevel(rs.getInt("alcoholLevel"));
			product.setPicture(rs.getString("picture"));
			//----------------------- 디버깅--------------------------
			System.out.println(product.getProductNo() + " <-- getProductNo() selectCategoryByPage() categoryDao");
			System.out.println(product.getName() + " <-- getproductName() selectCategoryByPage() categoryDao");
			System.out.println(product.getPrice() + " <-- getproductPrice() selectCategoryByPage() categoryDao"); 
			System.out.println(product.getVolume() + " <-- getproductPrice() selectCategoryByPage() categoryDao"); 
			System.out.println(product.getAlcoholLevel() + " <-- getAlocholLevel() selectCategoryByPage() categoryDao"); 
			System.out.println(product.getPicture() + " <-- getPicture() selectCategoryByPage() categoryDao"); 
			list.add(product);
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
	

}
