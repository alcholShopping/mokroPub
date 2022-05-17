package dao;

import java.sql.*;
import java.util.*;

import util.DBUtil;
import vo.Order;


public class OrderedDao {
	// 사용자아이디로 번호를 찾기
	public List<Order> selectOrderedById(int consumerNo){
		List<Order> OrderedList = new ArrayList<>();
		Order or = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT order_no orderNo, consumer_no consumerNo, product_no productNo, zipcode, address, detailed_address detailedAddress, payment, method, count, consumer_coupon_list_no couponListNo, create_date createDate, update_date updateDate"
				+ " FROM `order` "
				+ " WHERE consumer_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, consumerNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				or = new Order();
				or.setOrderNo(rs.getInt("orderNo"));
				or.setConsumerNo(rs.getInt("consumerNo"));
				or.setProductNo(rs.getInt("productNo"));
				or.setZipcode(rs.getString("zipcode"));
				or.setAddress(rs.getString("address"));
				or.setDetailedAddress(rs.getString("detailedAddress"));
				or.setPayment(rs.getString("payment"));
				or.setMethod(rs.getString("method"));
				or.setCount(rs.getInt("count"));
				or.setConsumerCouponListNo(rs.getString("couponListNo"));
				or.setCreateDate(rs.getString("createDate"));
				or.setUpdateDate(rs.getString("updateDate"));		
				OrderedList.add(or);
				
				// 디버깅
				System.out.println(or.getOrderNo() + " <-- orderNo selectOrderedById() OrderedDao ");
				System.out.println(or.getConsumerNo() + " <-- consumerNo selectOrderedById() OrderedDao ");
				System.out.println(or.getProductNo() + " <-- productNo selectOrderedById() OrderedDao ");
				System.out.println(or.getZipcode() + " <-- zipcode selectOrderedById() OrderedDao ");
				System.out.println(or.getAddress() + " <-- address selectOrderedById() OrderedDao ");
				System.out.println(or.getDetailedAddress() + " <-- detailedAddress selectOrderedById() OrderedDao ");
				System.out.println(or.getPayment() + " <-- payment selectOrderedById() OrderedDao ");
				System.out.println(or.getMethod() + " <-- method selectOrderedById() OrderedDao ");
				System.out.println(or.getCount() + " <-- count selectOrderedById() OrderedDao ");
				System.out.println(or.getConsumerCouponListNo() + " <-- couponListNo selectOrderedById() OrderedDao ");
				System.out.println(or.getCreateDate() + " <-- createDate selectOrderedById() OrderedDao ");
				System.out.println(or.getUpdateDate() + " <-- updateDate selectOrderedById() OrderedDao ");
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
