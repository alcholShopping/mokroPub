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

public class ReviewDao {
	
	public void InsertReviewByOrderNo(Review re){

		Connection conn = null;
		PreparedStatement stmt = null;

		
		//사진은 잠깐 NULL설정
		String sql = " INSERT INTO review( order_no, star, content, picture, create_date, update_date) "
				+ " VALUES( ? , ? , ? , ?, NOW(), NOW()) ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, re.getOrderNo());
			stmt.setInt(2, re.getStar());
			stmt.setString(3, re.getContent());
			stmt.setString(4, re.getPicture());
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
	
	
	public List<Map<String, Object>> SelectMyReviewById(int consumerNo){
		List<Map<String, Object>> reviewList = new ArrayList<Map<String, Object>>();
		Map<String, Object> re = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//사진은 잠깐 NULL설정
		String sql = " SELECT r.review_no reviewNo,r.picture picture,p.name name, r.content content, r.star star"
				+ " FROM review r "
				+ "	INNER JOIN `ORDER` o "
				+ "	ON r.order_no = o.order_no "
				+ "	INNER JOIN product p "
				+ "	ON o.product_no = p.product_no "
				+ " WHERE o.consumer_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, consumerNo);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				re = new HashMap<String, Object>();
				re.put("reviewNo", rs.getInt("reviewNo"));
				re.put("picture", rs.getString("picture"));
				re.put("name", rs.getString("name"));
				re.put("content", rs.getString("content"));
				re.put("star", rs.getInt("star"));
	
				System.out.println(re.get("reviewNo") + " <-- reviewNo SelectMyReviewById() ReviewDao ");
				System.out.println(re.get("picture") + " <-- picture SelectMyReviewById() ReviewDao ");
				System.out.println(re.get("name") + " <-- name SelectMyReviewById() ReviewDao ");
				System.out.println(re.get("content") + " <-- content SelectMyReviewById() ReviewDao ");
				System.out.println(re.get("star") + " <-- star SelectMyReviewById() ReviewDao ");	
				
				reviewList.add(re);
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
		return reviewList;

	}
}
