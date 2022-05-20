package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import vo.Consumer;

public class RefundDao {
	public void refundProduct(int orderNo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = " UPDATE delivery SET status='환불' WHERE order_no=? ORDER BY create_date desc";

		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, orderNo);
			int row = stmt.executeUpdate();
			
			if(row == 1) {
				System.out.println("환불 성공");
			}else {
				System.out.println("환불 실패");
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
