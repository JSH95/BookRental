package Save.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Db.Connector;

public class SaveRepo {
	public static boolean save(String tilte, String category, String writer, String company, int price, String status, int rental_price) {
		//
		boolean isSuccess = false;

		Connection conn = Connector.makeConn();
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO `book`");
		sql.append("(`tilte`, `category`, `writer`, `company`, `price`, `status`, `rental_user`, `return_day`, `rental_day`, `rental_price`)");
		sql.append(" values ");
		sql.append("(?, ?, ?, ?, ?, ?, NULL, NULL, NULL, ?)");
		
		try {
			//카테고리 0:만화책, 1 소설, 2 잡지
			//상태 0대여가능, 1대여중, 2분실
			
			PreparedStatement ps = conn.prepareStatement(sql.toString());
			ps.setString(1, tilte);
			ps.setString(2, category);
			ps.setString(3, writer);
			ps.setString(4, company);
			ps.setInt(5, price);
			ps.setString(6, status);
			ps.setInt(7, rental_price);
			
			//executeQuery : select 검색
			//executeUpdate : 나머지 검색
			int result = ps.executeUpdate();
			
			if(result > 0) {
				isSuccess = true;
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
}