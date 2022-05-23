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
	
	// 사용하는 쿠폰의 갯수를 조회
	public int selectUseCouponCount(int couponNo) {
		int UseCouponCount = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql= " SELECT count "
				+ " FROM consumer_coupon_list "
				+ " WHERE consumer_coupon_list_no = ? ";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, couponNo);

			rs=stmt.executeQuery();
			if(rs.next()) {
				UseCouponCount = rs.getInt("count");
				System.out.println(UseCouponCount);
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
		return UseCouponCount;
	}
	
	// 사용하는 쿠폰의 갯수를 조회
		public int isDayCouponByDay(int couponNo, int consumerId) {
			int result = -999;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql= "  SELECT DATEDIFF(NOW() , update_date) dateDiff "
					+ " FROM consumer_coupon_list "
					+ " WHERE coupon_no = ? && consumer_no = ? ";
			try {
				conn = DBUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, couponNo);
				stmt.setInt(2, consumerId);
				rs=stmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt("dateDiff");
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
			return result;
		}
	
	// 받으려는 쿠폰이 존재하는지 판별
		public int isSameCouponByCouponNum(int couponNo, int consumerId) {
			int UseCouponCount = 0;
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql= " select count "
					+ " FROM consumer_coupon_list "
					+ " WHERE coupon_no = ? && consumer_no = ? ";
			try {
				conn = DBUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, couponNo);
				stmt.setInt(2, consumerId);

				rs=stmt.executeQuery();
				if(rs.next()) {
					UseCouponCount = rs.getInt("count");
					System.out.println(UseCouponCount);
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
			return UseCouponCount;
		}
	
	// 데일리 쿠폰 증정(하루 1매씩 총 4개까지 가능)
		public void insertCouponListByName(int consumerNum, int couponNum) {
			int UseCouponCount = 0;
			Connection conn = null;
			PreparedStatement stmt = null;
			
			String sql= " INSERT INTO consumer_coupon_list(coupon_no, consumer_no, `count`, create_date, update_date) "
					+ " VALUES(?, ?, 1, NOW(), NOW()) ";
			try {
				conn = DBUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, couponNum);
				stmt.setInt(2, consumerNum);

				stmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
		}
		
		// 데일리 쿠폰 증정(이미 존재한다면 갯수를 하나 추가)
				public void UpdateCouponListByName(int consumerNum, int couponNum) {
					int UseCouponCount = 0;
					Connection conn = null;
					PreparedStatement stmt = null;
					
					String sql= " UPDATE consumer_coupon_list "
							+ " SET COUNT = COUNT + 1 "
							+ " WHERE coupon_no = ? && consumer_no = ? ";
					try {
						conn = DBUtil.getConnection();
						stmt = conn.prepareStatement(sql);
						stmt.setInt(1, couponNum);
						stmt.setInt(2, consumerNum);

						stmt.executeUpdate();

					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					} 
				}


	//쿠폰 갯수가 1개 일시 날짜와 시간을 변경하는 쿼리
	public void updateCouponValidity(int couponNo) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
					
		// 쿠폰을 1개씩 사용하게 하기
		String sql = " UPDATE coupon SET validity=\"0000-00-00\" "
				+ " WHERE coupon_no = "
				+ " (SELECT * FROM (SELECT c.coupon_no "
				+ " FROM coupon c INNER JOIN consumer_coupon_list cl"
				+ " ON c.coupon_no = cl.coupon_no "
				+ " WHERE cl.consumer_coupon_list_no = ?) as cou) ";
		try {

			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, couponNo);
			row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("쿠폰 변경 성공");
			}else {
				System.out.println("쿠폰 변경 실패");
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
	// 쿠폰을 1개씩 사용하게 하기
	public void updateCouponCount(int couponNo) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
					
		// 쿠폰을 1개씩 사용하게 하기
		String sql = " UPDATE consumer_coupon_list "
				+ " SET count = COUNT - 1 "
				+ " WHERE consumer_coupon_list_no = ?";
		try {

			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, couponNo);
			row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("쿠폰 변경 성공");
			}else {
				System.out.println("쿠폰 변경 실패");
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
}
