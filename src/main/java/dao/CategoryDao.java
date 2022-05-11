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

public class CategoryDao {
	// 카테코리에 따른 상품 리스트 출력
	public List<Product> selectCategoryByPage(int categoryNo){
		List<Product> list = new ArrayList<>();
		Product product = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs =null;
		//product에서 name,price,volume,alcohol_level alcoholLevel,picture 가져옴
		String sql=" SELECT name,price,volume,alcohol_level alcoholLevel,picture FROM product WHERE category_no = ? ";
	try {
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mokroPub","root","java1234");
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, categoryNo);
		rs = stmt.executeQuery();
		while(rs.next()) {
			product = new Product();
			product.setName(rs.getString("name"));
			product.setPrice(rs.getInt("price"));
			product.setVolume(rs.getInt("volume"));
			product.setAlcoholLevel(rs.getInt("alcoholLevel"));
			product.setPicture(rs.getString("picture"));
			//----------------------- 디버깅--------------------------
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
