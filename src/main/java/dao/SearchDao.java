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

public class SearchDao {
	/// productNo에 따른 Product 상세 출력
		public List<HashMap<String,Object>> searchSelectProduct(HashMap<String, Object> m){
			List<HashMap<String, Object>> list = new ArrayList<>();
			HashMap<String, Object> hash = null;
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			// productNo에 따른 필요한 상품 정보를 가져옴 
			String sql = "SELECT CONCAT(`NAME`,\" \",factory) concatName, price, volume, product_no "
					+ "FROM product "
					+ "WHERE "
					+ " CONCAT(`NAME`,\" \",factory) LIKE ? && "
					+ " price BETWEEN ? AND ? && "
					+ " volume BETWEEN 0 AND ? && "
					+ " color like ? && "
					+ " alcohol_level BETWEEN 0 AND ? && "
					+ " sweet BETWEEN 0 AND ? && "
					+ " maturity BETWEEN 0 AND ? && "
					+ " acidity BETWEEN 0 AND ? && "
					+ " thin BETWEEN 0 AND ? && "
					+ " refreshment BETWEEN 0 AND ? ";
			
			conn = DBUtil.getConnection();
			
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+ (String)m.get("name") +"%");
				stmt.setInt(2, (int)m.get("priceBefore"));
				stmt.setInt(3, (int)m.get("priceAfter"));
				stmt.setInt(4, (int)m.get("volume"));
				stmt.setString(5, "%"+ (String)m.get("color")  +"%");
				stmt.setInt(6, (int)m.get("alcoholLevel"));
				stmt.setInt(7, (int)m.get("sweet"));
				stmt.setInt(8, (int)m.get("maturity"));
				stmt.setInt(9, (int)m.get("acidity"));
				stmt.setInt(10, (int)m.get("thin"));
				stmt.setInt(11, (int)m.get("refreshment"));
				
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					
					hash = new HashMap<String, Object>();
					hash.put("name", rs.getString("concatName"));
					hash.put("price", rs.getInt("price"));
					hash.put("volume", rs.getInt("volume"));
					hash.put("product_no", rs.getInt("product_no"));

					list.add(hash);
					
					System.out.println(hash+"해시맵++++++++");
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
