package Modify.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Db.Connector;


public class ModifyRepo {
	public static boolean modify(String tilte, String category, String writer, String company, int price, String status, String rental_user, String return_day, String rental_day, int rental_price, int no) {
			//
			
		boolean isSuccess = false;
		Connection conn = Connector.makeConn();
//UPDATE `book` SET `tilte` = '돈키호테Update', `category` = '2', `writer` = '김경식Update', `company` = '빙그레출판사Update', `price` = '15000', `status` = '1', `rental_user` = '김빌림', `return_day` = '2023-12-18', `rental_day` = '2023-12-15', `rental_price` = '400' WHERE `book`.`no` = 1
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE `book` ");
		sql.append("SET ");
		sql.append("`tilte` = ?, ");
		sql.append("`category` = ?, ");
		sql.append("`writer` = ?, ");
		sql.append("`company` = ?, ");
		sql.append("`price` = ?, ");
		sql.append("`status` = ?, ");
		sql.append("`rental_user` = ?, ");	
		sql.append("`return_day` = ?, ");
		sql.append("`rental_day` = ?, ");
		sql.append("`rental_price` = ? ");
		sql.append("where ");
		sql.append("no = ? ");
		
				
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
			ps.setString(7, rental_user);
			ps.setString(8, return_day);
			ps.setString(9, rental_day);
			ps.setInt(10, rental_price);
			ps.setInt(11, no);

			
			
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