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
import vo.Product;

public class ProductDao {
	
	/// productNo에 따른 Product 상세 출력
	public List<Map<String,Object>> selectProductOne(int productNo){
		List<Map<String, Object>> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// productNo에 따른 필요한 상품 정보를 가져옴 
		String sql = "SELECT p.product_no productNo"
				+ "		, p.NAME name "
				+ "		, p.price price "
				+ "		, p.volume volume "
				+ "		, m.name materialName "
				+ "		, o.name originName "
				+ "		, p.manufacture_Date manufactureDate "
				+ "		, p.expiration_date expirationDate "
				+ "		, p.alcohol_level alcoholLevel "
				+ "		, p.factory factory "
				+ "		, p.color color "
				+ " 	, p.bottle bottle "
				+ "		, p.region region "
				+ "		, p.smell smell "
				+ "		, p.sweet sweet "
				+ "		, p.maturity maturity "
				+ "		, p.picture picture "
				+ "		, p.acidity acidity "
				+ "		, p.thin thin "
				+ "		, p.refreshment refreshment "
				+ "		, p.report_number reportNumber "
				+ "		, p.memo memo "
				+ "		, c.`type` categoryType "
				+ "		, com.name companyName "
				+ " FROM product p "
				+ " INNER JOIN material_origin_list mol "
				+ " ON  p.material_origin_no = mol.material_origin_no"
				+ " INNER JOIN material m "
				+ " ON  m.material_no = mol.material_no "
				+ " INNER JOIN origin o "
				+ " ON o.origin_no = mol.origin_no "
				+ " INNER JOIN category c "
				+ " ON p.category_no = c.category_no "
				+ " INNER JOIN company com "
				+ " ON p.company_no = com.company_no "
				+ " WHERE p.product_no = ?";
		
		conn = DBUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("productNo", rs.getInt("productNo"));
				m.put("name", rs.getString("name"));
				m.put("price", rs.getInt("price"));
				m.put("volume", rs.getInt("volume"));
				m.put("materialName", rs.getString("materialName"));
				m.put("originName", rs.getString("originName"));
				m.put("manufactureDate", rs.getString("manufactureDate"));
				m.put("expirationDate", rs.getString("expirationDate"));
				m.put("alcoholLevel", rs.getInt("alcoholLevel"));
				m.put("factory", rs.getString("factory"));
				m.put("color", rs.getString("color"));
				m.put("bottle", rs.getString("bottle"));
				m.put("region", rs.getString("region"));
				m.put("smell", rs.getString("smell"));
				m.put("sweet", rs.getInt("sweet"));
				m.put("maturity", rs.getInt("maturity"));
				m.put("picture", rs.getString("picture"));
				m.put("acidity", rs.getInt("acidity"));
				m.put("thin", rs.getInt("thin"));
				m.put("refreshment", rs.getInt("refreshment"));
				m.put("memo", rs.getString("memo"));
				m.put("categoryType", rs.getString("categoryType"));
				m.put("companyName", rs.getString("companyName"));
				//----------------------- 디버깅--------------------------
				System.out.println(m.get("productNo") + " <-- productNo selectProductOne() ProductDao ");
				System.out.println(m.get("name") + " <-- name selectProductOne() ProductDao ");
				System.out.println(m.get("price") + " <-- price selectProductOne() ProductDao ");
				System.out.println(m.get("volume") + " <-- volume selectProductOne() ProductDao ");
				System.out.println(m.get("materialName") + " <-- materialName selectProductOne() ProductDao ");
				System.out.println(m.get("originName") + " <-- originName selectProductOne() ProductDao ");
				System.out.println(m.get("manufactureDate") + " <-- manufactureDate selectProductOne() ProductDao ");
				System.out.println(m.get("expirationDate") + " <-- expirationDate selectProductOne() ProductDao ");
				System.out.println(m.get("alcoholLevel") + " <-- alcoholLevel selectProductOne() ProductDao ");
				System.out.println(m.get("factory") + " <-- factory selectProductOne() ProductDao ");
				System.out.println(m.get("color") + " <-- color selectProductOne() ProductDao ");
				System.out.println(m.get("bottle") + " <-- bottle selectProductOne() ProductDao ");
				System.out.println(m.get("region") + " <-- region selectProductOne() ProductDao ");
				System.out.println(m.get("smell") + " <-- smell selectProductOne() ProductDao ");
				System.out.println(m.get("sweet") + " <-- sweet selectProductOne() ProductDao ");
				System.out.println(m.get("maturity") + " <-- maturity selectProductOne() ProductDao ");
				System.out.println(m.get("picture") + " <-- picture selectProductOne() ProductDao ");
				System.out.println(m.get("acidity") + " <-- acidity selectProductOne() ProductDao ");
				System.out.println(m.get("thin") + " <-- thin selectProductOne() ProductDao ");
				System.out.println(m.get("refreshment") + " <-- refreshment selectProductOne() ProductDao ");
				System.out.println(m.get("memo") + " <-- memo selectProductOne() ProductDao ");
				System.out.println(m.get("categoryType") + " <-- categoryType selectProductOne() ProductDao ");
				System.out.println(m.get("companyName") + " <--companyName selectProductOne() ProductDao ");
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
		return list;
	}
}
