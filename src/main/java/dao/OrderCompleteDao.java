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
import vo.*;
public class OrderCompleteDao {
	
	//주문 완료 시 주문 테이블에 입력하는 메서드
	public void insertInOrder(int consumerNo,int productNo,String zipcode,String addr,String detailedAddress,int payment,int count ,int couponNo) {
		/*
		 * order테이블에 데이터를 집어 넣는 쿼리
		 * INSERT INTO `order` VALUES(?,?,?,?,?,?,?,?,?,?,NOW(),NOW());
		 */
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
					
		// consumer_id, password, name, phone, email, address, Detailed_Addreess, Account, UPDATE_DATE
		String sql = " INSERT INTO `order` ( `consumer_no`"
				+ ", `product_no`"
				+ ", `zipcode`"
				+ ", `address`"
				+ ", `detailed_address`"
				+ ", `payment`"
				+ ", `method`"
				+ ", `count`"
				+ ", `consumer_coupon_list_no`"
				+ ", `create_date`"
				+ ", `update_date`) "
				+ "  VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(),NOW()); ";
		// DB값 요청
		// DB에 저장하고 나서 controller에서 받은 jsp값을 받은 값을 DB에 요청 그리고 저장
		try {

			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, consumerNo);
			stmt.setInt(2, productNo);
			stmt.setString(3, zipcode);
			stmt.setString(4, addr);
			stmt.setString(5, detailedAddress);
			stmt.setInt(6, payment);
			stmt.setString(7, "무통장입금");
			stmt.setInt(8, count);
			stmt.setInt(9, couponNo);
	
			row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("입력 성공");
			}else {
				System.out.println("입려 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	// 카드에 따른 상품번호와 가격 갯수
	public List<Map<String,Object>> selectCartProduct(int consumerNo){
		List<Map<String, Object>> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 카드에 따른 상품번호와 갯수
		String sql = " SELECT c.product_no productNo, c.count count, p.price price"
				+ " FROM cart c INNER JOIN product p"
				+ " ON c.product_no = p.product_no "
				+ " WHERE c.consumer_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, consumerNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("productNo", rs.getInt("productNo"));
				m.put("count", rs.getInt("count"));
				m.put("price", rs.getInt("price"));
				//-----------------------디버깅
				System.out.println(m.get("productNo") + " <-- productNo selectCartProduct() OrderCompleteDao  ");
				System.out.println(m.get("count") + " <-- count selectCartProduct() OrderCompleteDao  ");
				System.out.println(m.get("price") + " <-- count selectCartProduct() OrderCompleteDao  ");
				
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
   
	// 카드에 따른 상품번호와 갯수
		public int  selectCouponNo(int consumerNo, int discount){
			int CouponNo = 0;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			// 카드에 따른 상품번호와 갯수
			String sql = " SELECT cl.consumer_coupon_list_no consumerCouponListNo "
					+ " from coupon c INNER  JOIN consumer_coupon_list cl "
					+ " ON c.coupon_no =  cl.coupon_no "
					+ " WHERE c.discount = ? AND cl.consumer_no = ? ; ";
			
			try {
				conn = DBUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, discount);
				stmt.setInt(2, consumerNo);
				rs = stmt.executeQuery();
				if(rs.next()) {
					CouponNo = rs.getInt("consumerCouponListNo");
					System.out.println(CouponNo);
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
			return CouponNo;
		}

}
	

