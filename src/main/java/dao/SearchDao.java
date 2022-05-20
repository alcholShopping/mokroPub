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
		public List<Map<String,Object>> searchSelectProduct(HashMap<String, Object> m){
			List<Map<String, Object>> list = new ArrayList<>();
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
	
		 	// 검색한 데이터(상품번호, 이름,가격, 용량, 도수,사진 등)를 보여주는 쿼리
			String sql = "SELECT name, price, volume, product_no, picture, alcohol_Level "
					+ "FROM product "
					+ "WHERE "
					+ " name LIKE ? && "
					+ " price BETWEEN ? AND ? && "
					+ " volume BETWEEN ? AND ? && "
					+ " color like ? && "
					+ " alcohol_level BETWEEN ? AND ? && "
					+ " sweet BETWEEN ? AND ? && "
					+ " maturity BETWEEN ? AND ? && "
					+ " acidity BETWEEN ? AND ? && "
					+ " thin BETWEEN ? AND ? && "
					+ " refreshment BETWEEN ? AND ? ";
			conn = DBUtil.getConnection();
			
			try { // 검색할 데이터를 가져옴 
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%"+ (String)m.get("name") +"%");
				stmt.setInt(2, (int)m.get("priceBefore"));
				stmt.setInt(3, (int)m.get("priceAfter"));
				stmt.setInt(4, (int)m.get("volumeBefore"));
				stmt.setInt(5, (int)m.get("volumeAfter"));
				stmt.setString(6, "%"+ (String)m.get("color")  +"%");
				stmt.setInt(7, (int)m.get("alcoholLevelBefore"));
				stmt.setInt(8, (int)m.get("alcoholLevelAfter"));
				stmt.setInt(9, (int)m.get("sweetBefore"));
				stmt.setInt(10, (int)m.get("sweetAfter"));
				stmt.setInt(11, (int)m.get("maturityBefore"));
				stmt.setInt(12, (int)m.get("maturityAfter"));
				stmt.setInt(13, (int)m.get("acidityBefore"));
				stmt.setInt(14, (int)m.get("acidityAfter"));
				stmt.setInt(15, (int)m.get("thinBefore"));
				stmt.setInt(16, (int)m.get("thinAfter"));
				stmt.setInt(17, (int)m.get("refreshmentBefore"));
				stmt.setInt(18, (int)m.get("refreshmentAfter"));
				rs = stmt.executeQuery();
				
				while(rs.next()) { // 검색리스트에 보여줄 값을 DB에서 추출
					Map<String, Object> hash = new HashMap<String, Object>();
					hash.put("picture", rs.getString("picture"));
					hash.put("name", rs.getString("name"));
					hash.put("price", rs.getInt("price"));
					hash.put("volume", rs.getInt("volume"));
					hash.put("productNo", rs.getInt("product_no"));
					hash.put("alcoholLevel", rs.getInt("alcohol_Level"));
					
					System.out.println(hash.get("picture") + " <-- picture searchSelectProduct() SearchDao ");
					System.out.println(hash.get("name") + " <-- name searchSelectProduct() SearchDao ");
					System.out.println(hash.get("price") + " <-- price searchSelectProduct() SearchDao ");
					System.out.println(hash.get("volume") + " <-- volume searchSelectProduct() SearchDao ");
					System.out.println(hash.get("productNo") + " <-- productNo searchSelectProduct() SearchDao ");
					System.out.println(hash.get("alcoholLevel") + " <-- alcoholLevel searchSelectProduct() SearchDao ");
					list.add(hash);
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
