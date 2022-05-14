package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import vo.Category;
import vo.Consumer;

public class ConsumerDao {
	// consumerOne의 회원정보를 보여주는 메서드
	public List<Consumer> selectConsumerOneInfo(String sessionMemberId){
		List<Consumer> list = new ArrayList<>();
		Consumer consumer = null;	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// consumerId, name, phone, email, address, detailedAddress, consumerLevel, adultCertification, account, createDate를 가져옴
		String sql = " SELECT consumer_id consumerId, NAME, phone, email, address, detailed_Address detailedAddress, consumer_level consumerLevel, ACCOUNT, create_date createDate "
				+ " FROM consumer WHERE consumer_id = ?  ";
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, sessionMemberId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				consumer = new Consumer();
				consumer.setConsumerId(rs.getString("consumerId"));
				consumer.setName(rs.getString("name"));
				consumer.setPhone(rs.getString("phone"));
				consumer.setEmail(rs.getString("email"));
				consumer.setAddress(rs.getString("address"));
				consumer.setDetailedAddr(rs.getString("detailedAddress"));
				consumer.setConsumerLevel(rs.getInt("consumerLevel"));
				consumer.setAccount(rs.getString("account"));
				consumer.setCreateDate(rs.getString("createDate"));
				
				// 디버깅
				System.out.println(consumer.getConsumerId() + " <-- consumerId selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getName() + " <-- name selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getPhone() + " <-- phone selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getEmail() + " <-- email selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getAddress() + " <-- address selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getDetailedAddr() + " <-- detailedAddress selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getConsumerLevel() + " <-- consumerLevel selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getAccount() + " <-- ACCOUNT selectConsumerOneInfo() ConsumerDao ");
				System.out.println(consumer.getCreateDate() + " <-- createDate selectConsumerOneInfo() ConsumerDao ");
				list.add(consumer);
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
	
}
