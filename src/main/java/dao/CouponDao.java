package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.DBUtil;

public class CouponDao {
	
	// consumerId에 따른 쿠폰 사용 가능 리스트
	public List<HashMap<String, Object>> selectConsumerCouponList(int consumerId) {
		List<HashMap<String, Object>> couponList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> hash = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// consumerId에 따른 사용 가능 리스트 출력
		String sql = " SELECT cl.consumer_coupon_list_no cListNo"
				+ " , cl.coupon_no couponNo"
				+ " , cl.consumer_no consumerNo"
				+ " , cl.count count"
				+ " , c.validity validity"
				+ " , c.discount discount "
				+ " FROM consumer_coupon_list cl "
				+ "	INNER JOIN coupon c "
				+ "		ON cl.coupon_no = c.coupon_no "
				+ " WHERE cl.consumer_no = ? AND NOW() < validity ";
		
		conn = DBUtil.getConnection();
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, consumerId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				hash = new HashMap<String, Object>();
				hash.put("cListNo", rs.getInt("cListNo"));
				hash.put("couponNo", rs.getInt("couponNo"));
				hash.put("consumerNo", rs.getInt("consumerNo"));
				hash.put("count", rs.getInt("count"));
				hash.put("discount", rs.getInt("discount"));
				hash.put("validity", rs.getString("validity"));

				//----------------------- 디버깅--------------------------
				System.out.println(hash.get("cListNo") + " <-- cListNo selectConsumerCouponList() CouponDao ");
				System.out.println(hash.get("couponNo") + " <-- couponNo selectConsumerCouponList() CouponDao ");
				System.out.println(hash.get("consumerNo") + " <-- consumerNo selectConsumerCouponList() CouponDao ");
				System.out.println(hash.get("count") + " <-- count selectConsumerCouponList() CouponDao ");
				System.out.println(hash.get("discount") + " <-- discount selectConsumerCouponList() CouponDao ");
				System.out.println(hash.get("validity") + " <-- validity selectConsumerCouponList() CouponDao ");

				couponList.add(hash);
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
		
		return couponList;
	}
	
}
