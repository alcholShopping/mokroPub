package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import util.DBUtil;

public class CartDao {
	
	// 상품을 장바구니에 추가
	public void insertProductInCart(int productNo, int count, int consumerId) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// productNo, count, sessionMemberId에 따라서 cart 추가 
		String sql=" INSERT INTO cart (product_no,consumer_no,`count`,create_date,update_date) "
				+ " VALUE(?,?,?,NOW(),NOW()); ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productNo);
			stmt.setInt(2, consumerId);
			stmt.setInt(3, count);
			row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
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
	
	// 상품이 이미 장바구니에 존재한다면 수량을 하나 추가
	public void updateProductInCart(int productNo, int count, int consumerId) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// CART에 있는 상품의 개수를 업데이트
		String sql=" UPDATE cart "
				+ " SET COUNT = COUNT + ? "
				+ " WHERE consumer_no = ? AND product_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, count);
			stmt.setInt(2, consumerId);
			stmt.setInt(3, productNo);
			row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
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
	
	// 사용자아이디를 숫자로 변경
	public int changeConsumerIdToNo(String sessionMemberId) {
		int consumerId = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// productNo, count, sessionMemberId에 따라서 cart 추가 
		String sql= "SELECT consumer_no consumerNo FROM consumer WHERE consumer_id = ? ";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, sessionMemberId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				consumerId = rs.getInt("consumerNo");
				System.out.println(consumerId + " <-- consumerId changeConsumerIdToNo() CartDao <-- 이동해야함");
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
		return consumerId;
	}
	
	// 사용자가 같은 상품을 담았는지 판별
	public int IsSameProductCart(int productNo, int consumerId) {
		int productCnt = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 동일한 사용자가 같은 상품을 몇 개 담았는지 보여줌
		String sql= "SELECT COUNT(*) cnt "
				+ " FROM cart c INNER JOIN product p "
				+ " ON c.product_no =  p.product_no "
				+ " WHERE c.consumer_no = ? and c.product_no = ? ";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, consumerId);
			stmt.setInt(2, productNo);
			rs = stmt.executeQuery();
			if(rs.next()) {
				productCnt = rs.getInt("cnt");
				System.out.println(productCnt + " <-- productCnt IsSameProductCart() CartDao");
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
		return productCnt;
	}

	public List<Map<String, Object>> selectConsumerCartList(int consumerId){
		List<Map<String, Object>> consumerList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 사용자가 담은 장바구니 리스트
		String sql = " SELECT c.cart_no cartNo, CONCAT(p.name,\" \",p.volume,\"ml \",p.alcohol_level,\"도\") name, p.price price, c.count count, p.picture picture "
				+ " FROM cart c INNER JOIN product p  "
				+ " ON c.product_no = p.product_no "
				+ " WHERE c.consumer_no = ?  ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, consumerId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("cartNo", rs.getInt("cartNo"));
				m.put("name", rs.getString("name"));
				m.put("price", rs.getInt("price"));
				m.put("count", rs.getInt("count"));
				m.put("picture", rs.getString("picture"));	

				// 디버깅
				System.out.println(m.get("cartNo") + " <-- cartNo selectConsumerCartList() CartDao ");
				System.out.println(m.get("name") + " <-- name selectConsumerCartList() CartDao ");
				System.out.println(m.get("price") + " <-- price selectConsumerCartList() CartDao ");
				System.out.println(m.get("count") + " <-- volume selectConsumerCartList() CartDao ");
				System.out.println(m.get("picture") + " <-- picture selectConsumerCartList() CartDao ");
				
				consumerList.add(m);
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
		return consumerList;
	}
	
	//장바구니에 상품 단일 삭제
	public void DeleteProductInCart(int cartNo) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// 장바구니 삭제 쿼리
		String sql = " DELETE FROM cart WHERE cart_no = ? ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cartNo);

			row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("단일 상품 삭제 성공");
			} else {
				System.out.println("단일 상품 삭제 실패");
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
	
	//장바구니에 상품 단일 삭제
	public void DeleteProductInCartAll(int consumerId) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
			
		// 장바구니 삭제 쿼리
		String sql = " DELETE FROM cart WHERE consumer_no = ? ";
			
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, consumerId);

			row = stmt.executeUpdate();
			if(row == 1) {
				System.out.println("전체 상품 삭제 성공");
			} else {
				System.out.println("전체 상품 삭제 실패");
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
		
	//상단바 장바구니 담긴 개수
	public int CartCountNum(int cunsumerId) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 동일한 사용자가 같은 상품을 몇 개 담았는지 보여줌
		String sql= " SELECT COUNT(*) cnt FROM cart "
				+ " WHERE consumer_no = ? ";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,cunsumerId);

			rs = stmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("cnt");
				System.out.println(cnt + " <-- cnt CartCountNum() CartDao");
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
		return cnt;
	}
}

