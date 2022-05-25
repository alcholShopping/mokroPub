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
import vo.Product;

public class BestDao {
   // 인기 15위를 보여주는 메서드
   public List<Map<String,Object>> selectBestListByPage(){
      List<Map<String, Object>> list = new ArrayList<>();
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      // order 상품 판매 주문순으로 15개 나열
      String sql = " SELECT p.product_no, p.name, p.price,p.picture ,p.volume,p.alcohol_level, o.product_no, o.cnt "
            + " FROM (SELECT product_no, COUNT(*) cnt FROM `order` GROUP BY product_no) o INNER JOIN product p "
            + " ON p.product_no = o.product_no "
            + " order BY o.cnt desc "
            + " LIMIT 0, 14 ";
      
      try {
         conn = DBUtil.getConnection();
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery();
         while(rs.next()) {
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("productNo", rs.getInt("p.product_no"));
            m.put("name", rs.getString("p.name"));
            m.put("picture", rs.getString("p.picture"));
            m.put("price", rs.getString("p.price"));
            m.put("volume", rs.getString("p.volume"));
            m.put("alcoholLevel", rs.getString("p.alcohol_level"));
            // 디버깅
            System.out.println(m.get("productNo") + " <-- productNo selectBestListByPage() BestDao ");
            System.out.println(m.get("name") + " <-- name selectBestListByPage() BestDao ");
            System.out.println(m.get("picture") + " <-- picture selectBestListByPage() BestDao ");
            System.out.println(m.get("price") + " <-- price selectBestListByPage() BestDao ");
            System.out.println(m.get("volume") + " <-- volume selectBestListByPage() BestDao ");
            System.out.println(m.get("alcoholLevel") + " <-- alcoholLevel selectBestListByPage() BestDao ");
            list.add(m);
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
   
   // Index에 인기 순위를 보여주는 메서드
      public List<Map<String,Object>> selectBestListByPageIndex(){
         List<Map<String, Object>> list = new ArrayList<>();
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         // order 상품 판매 주문순으로 15개 나열
         String sql = " SELECT p.product_no, "
         		+ "			p.name, "
         		+ "			p.price, "
         		+ "			p.picture,"
         		+ "			p.volume, "
         		+ "			p.alcohol_level, "
         		+ "			o.product_no, "
         		+ "		   o.cnt "
         		+ "		FROM (SELECT product_no, "
         		+ "			 			COUNT(*) cnt "
         		+ "				FROM `order` "
         		+ "						 GROUP BY product_no "
         		+ "					) o \r\n"
         		+ "			INNER JOIN product p ON p.product_no = o.product_no "
         		+ "			order BY o.cnt desc "
         		+ "			LIMIT 0, 3";
         
         try {
            conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
               Map<String, Object> m = new HashMap<String, Object>();
               m.put("productNo", rs.getInt("p.product_no"));
               m.put("name", rs.getString("p.name"));
               m.put("picture", rs.getString("p.picture"));
               m.put("price", rs.getString("p.price"));
               m.put("volume", rs.getString("p.volume"));
               m.put("alcoholLevel", rs.getString("p.alcohol_level"));
               // 디버깅
               System.out.println(m.get("productNo") + " <-- productNo selectBestListByPage() BestDao ");
               System.out.println(m.get("name") + " <-- name selectBestListByPage() BestDao ");
               System.out.println(m.get("picture") + " <-- picture selectBestListByPage() BestDao ");
               System.out.println(m.get("price") + " <-- price selectBestListByPage() BestDao ");
               System.out.println(m.get("volume") + " <-- volume selectBestListByPage() BestDao ");
               System.out.println(m.get("alcoholLevel") + " <-- alcoholLevel selectBestListByPage() BestDao ");;
               list.add(m);
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