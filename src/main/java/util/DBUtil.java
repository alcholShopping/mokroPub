package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String dburl = "jdbc:mariadb://localhost:3306/mokroPub";
			String dbuser = "root";
			String dbpw = "java1234";
			conn = DriverManager.getConnection(dburl,dbuser,dbpw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}