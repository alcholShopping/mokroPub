package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.Category;

public class IndexDao {
	// nav에 주류리스트 출력
	public List<Category> selectCategoryList()	{
		List<Category> list = new ArrayList<>();
		Category category = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// category에서 no과 type 가져옴
		String sql = " SELECT category_no categoryNo, type FROM category ";
		conn = DBUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				category = new Category();
				category.setCategoryNo(rs.getInt("categoryNo"));
				category.setType(rs.getString("type"));
				// -------------------------- 디버깅 ------------------------------
				System.out.println(category.getCategoryNo() + " <-- getCategoryNo() selectCategoryList() indexDao");
				System.out.println(category.getType() + " <-- getType() selectCategoryList() indexDao"); 
				list.add(category);
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
