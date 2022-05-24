package dao;

import java.sql.*;
import java.util.*;

import util.DBUtil;
import vo.Order;
import vo.Product;


public class OrdereAfterDao {
	// 사용자아이디로 번호를 찾기
	public List<Map<String,Object>> selectOrderedById(int consumerNo){
		List<Map<String,Object>> OrderedList = new ArrayList<Map<String,Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="SELECT o.order_no orderNo   "
				+ ", o.consumer_no consumerNo   "
				+ ", o.zipcode    "
				+ ", o.address    "
				+ ", o.detailed_address detailedAddress    "
				+ ", o.payment   "
				+ ", o.method   "
				+ ", o.count    "
				+ ", o.consumer_coupon_list_no couponListNo   "
				+ ", o.create_date createDate    "
				+ ", o.update_date updateDate  "
				+ ", d.`status`   "
				+ ", p.name  "
				+ ", p.price   "
				+ ", p.volume   "
				+ ", p.alcohol_level   "
				+ ", p.picture   "
				+ ", p.product_no  "
				+ "FROM `order` o   "
				+ "INNER JOIN delivery d   "
				+ "ON o.order_no = d.order_no    "
				+ "INNER JOIN product p   "
				+ "ON o.product_no = p.product_no   "
				+ "WHERE o.consumer_no = ? "
				+ "ORDER BY o.create_date DESC " ; 
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, consumerNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String,Object> m = new HashMap<String,Object>();
				m.put("orderNo", rs.getInt("orderNo"));
				m.put("consumerNo", rs.getInt("consumerNo"));
				m.put("zipcode", rs.getString("o.zipcode"));
				m.put("address", rs.getString("o.address"));
				m.put("payment", rs.getInt("o.payment"));
				m.put("method", rs.getString("o.method"));
				m.put("count", rs.getInt("o.count"));
				m.put("status", rs.getString("d.status"));
				m.put("productName", rs.getString("p.name"));
				m.put("price", rs.getString("p.price"));
				m.put("volume", rs.getString("p.volume"));
				m.put("alcoholLevel", rs.getString("p.alcohol_level"));
				m.put("picture", rs.getString("p.picture"));
				m.put("productNo", rs.getString("p.product_no"));
				m.put("couponListNo", rs.getInt("couponListNo"));
				m.put("createDate", rs.getString("createDate"));
				m.put("updateDate", rs.getString("updateDate"));
				
				OrderedList.add(m);
				// 디버깅
				System.out.println(m.get("orderNo") + "<----orderNo  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("consumerNo") + "<----consumerNo  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("zipcode") + "<----zipcode  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("address") + "<----address  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("payment") + "<----payment  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("method") + "<----method  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("count") + "<----count  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("status") + "<----status  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("productName") + "<----productName  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("price") + "<----price  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("volume") + "<----volume  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("alcoholLevel") + "<----alcoholLevel  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("picture") + "<---picture  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("productNo") + "<----productNo  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("couponListNo") + "<----couponListNo  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("productName") + "<----productName  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("createDate") + "<----createDate  selectOrderedById()  OrdereAfterDao");
				System.out.println(m.get("updateDate") + "<----updateDate  selectOrderedById()  OrdereAfterDao");
				
				
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
		
		return OrderedList;

	}

} 
