package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
