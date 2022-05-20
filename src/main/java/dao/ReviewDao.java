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
	
	public String SelectProdctNameByOrderNo(int orderNo){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String pName = "";
		//사진은 잠깐 NULL설정
		String sql = " SELECT p.name "
				+ " FROM `order` o "
				+ "     INNER JOIN product p "
				+ " 	ON o.product_no = p.product_no "
				+ " WHERE o.order_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderNo);

			rs = stmt.executeQuery();
			
			while(rs.next()) {
				pName = rs.getString("p.name");
				
				System.out.println(pName + " ==================== pNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepName");
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
		
		return pName;
	}
	
	public String SelectProdctNameByReviewNo(int ReviewNo){

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String pName = "";
		//사진은 잠깐 NULL설정
		String sql = " SELECT p.name "
				+ " FROM review r "
				+ "	INNER JOIN `order` o "
				+ "	ON r.order_no = o.order_no "
				+ "	INNER JOIN product p "
				+ "	ON p.product_no = o.product_no "
				+ " WHERE review_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ReviewNo);

			rs = stmt.executeQuery();
			
			while(rs.next()) {
				pName = rs.getString("p.name");
				
				System.out.println(pName + " ==================== pNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepNamepName");
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
		
		return pName;
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
				+ " WHERE o.consumer_no = ? ORDER BY reviewNo DESC";
		
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
	
	public List<Map<String, Object>> SelectReviewByProduct(int productNo){
		List<Map<String, Object>> reviewProductList = new ArrayList<Map<String, Object>>();
		Map<String, Object> re = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 상품 리뷰 3개만 받아오기
		String sql =
				" SELECT c.name, r.picture, r.star, r.content, r.create_date "
				+ " FROM review r "
				+ "	INNER JOIN `ORDER` o  "
				+ "	ON r.order_no = o.order_no "
				+ "	INNER JOIN product p  "
				+ "	ON o.product_no = p.product_no  "
				+ "	INNER JOIN consumer c "
				+ "	ON o.consumer_no = c.consumer_no  "
				+ " WHERE o.product_no = ? "
				+ " order BY create_date DESC "
				+ " LIMIT 0, 3 ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productNo);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				re = new HashMap<String, Object>();
				re.put("name", rs.getString("c.name"));
				re.put("picture", rs.getString("r.picture"));
				re.put("star", rs.getInt("r.star"));
				re.put("content", rs.getString("r.content"));
				re.put("createDate", rs.getString("r.create_date"));

				
				reviewProductList.add(re);
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
		return reviewProductList;
	}
	
	
	public List<Map<String, Object>> SelectReviewByProductFull(int productNo){
		List<Map<String, Object>> reviewProductList = new ArrayList<Map<String, Object>>();
		Map<String, Object> re = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 상품 리뷰 3개만 받아오기
		String sql =
				" SELECT c.name, r.picture, r.star, r.content, r.create_date "
				+ " FROM review r "
				+ "	INNER JOIN `ORDER` o  "
				+ "	ON r.order_no = o.order_no "
				+ "	INNER JOIN product p  "
				+ "	ON o.product_no = p.product_no  "
				+ "	INNER JOIN consumer c "
				+ "	ON o.consumer_no = c.consumer_no  "
				+ " WHERE o.product_no = ? "
				+ " order BY create_date DESC ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productNo);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				re = new HashMap<String, Object>();
				re.put("name", rs.getString("c.name"));
				re.put("picture", rs.getString("r.picture"));
				re.put("star", rs.getInt("r.star"));
				re.put("content", rs.getString("r.content"));
				re.put("createDate", rs.getString("r.create_date"));

				
				reviewProductList.add(re);
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
		return reviewProductList;
	}
	
	
	public void DeleteMyReviewByNo(int reviewNo) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// 삭제쿼리
		String sql = " DELETE FROM review WHERE review_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, reviewNo);

			row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("리뷰삭제성공!!!");
			} else {
				System.out.println("리뷰삭제실패!!!");
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
		
}
	
	public Review SelectReviewByOrderNo(int reviewNo){
		Review rev = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		String sql = " SELECT order_no, star, content, picture, create_date, update_date "
				+ " FROM review where review_No = ? ORDER BY order_no desc";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, reviewNo);
			
			System.out.println(reviewNo+"reviewNo~!!!!!!!!!!");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				rev = new Review();
				rev.setReviewNo(reviewNo);
				rev.setStar(rs.getInt("star"));
				rev.setContent(rs.getString("content"));
				rev.setPicture(rs.getString("picture"));
				rev.setCreateDate(rs.getString("create_date"));
				rev.setUpdateDate(rs.getString("update_date"));
				
				System.out.println(rev+"rev~!!!!!!!!!!");
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
		
		return rev;
	}
	
	
	public void UpdateReviewByOrderNo(Review re){

		Connection conn = null;
		PreparedStatement stmt = null;

		
		System.out.println(re + "rev sql문 출력!======================");
		String sql = " UPDATE review "
				+ " SET star = ?, content = ?, picture = ?, update_date = NOW() "
				+ " WHERE review_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, re.getStar());
			stmt.setString(2, re.getContent());
			stmt.setString(3, re.getPicture());
			stmt.setInt(4, re.getReviewNo());
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
	
}
