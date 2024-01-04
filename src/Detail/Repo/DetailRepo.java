package Detail.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Db.Connector;

public class DetailRepo {

	public static String[] detail(String no) { 
		Connection conn = Connector.makeConn();
		String[] bookInfo = new String[11];
		
		String sql = "select * from book where no = ? ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setInt(1, Integer.parseInt(no));//숫자 변환
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) { //정보가 맞다면 데이터 갯수 만큼 증가
				//String num = String.valueOf(rs.getInt(1));
				String title = rs.getString(2);
				String category = rs.getString(3);
				String writer = rs.getString(4);
				String company = rs.getString(5);
				String status = rs.getString(7);
				String price = rs.getString(6);
				String rental_user = rs.getString(8);
				String return_day = rs.getString(9);
				String rental_day = rs.getString(10);
				String rental_price = rs.getString(11);
				
				
				bookInfo[0]= no;
				bookInfo[1]= title;
				bookInfo[2]= category;
				bookInfo[3]= writer;
				bookInfo[4]= company;
				bookInfo[5]= status;
				bookInfo[6]= price;
				bookInfo[7]= rental_user;
				bookInfo[8]= return_day;
				bookInfo[9]= rental_day;
				bookInfo[10]= rental_price;
	
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return bookInfo;
	}
		
}