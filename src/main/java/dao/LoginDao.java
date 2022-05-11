package dao;

import vo.*;
import java.util.*;
import java.sql.*;

public class LoginDao {
	public String selectMemberByIdPw(String id, String pw) throws Exception {

		String memberId = null;
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT consumer_id  from consumer where consumer_id= ? and password = PASSWORD(?)";

        conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mokropub","root","java1234");
        stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setString(2, pw);
		rs  = stmt.executeQuery();

		if(rs.next()) {
		memberId = rs.getString("consumer_id");
		}

		return memberId;
	}
}
