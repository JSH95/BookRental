package List.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Db.Connector;
import sun.font.StrikeCache;

public class ListRepo {

	public String[][] list() {
		Connection conn = Connector.makeConn();
		String[][] result = new String[0][0];
		
		String sql = "select* from book";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql,
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			
			result = new String[count][6];
			int i = 0;
			while(rs.next()) { //정보가 맞다면 데이터 갯수 만큼 증가
				String[] bookInfo = new String[6];
				
				String num = String.valueOf(rs.getInt(1));
				String title = rs.getString(2);
				String category = rs.getString(3);
				String writer = rs.getString(4);
				String company = rs.getString(5);
				String status = rs.getString(7);
				
				bookInfo[0]= num;
				bookInfo[1]= title;
				bookInfo[2]= category;
				bookInfo[3]= writer;
				bookInfo[4]= company;
				bookInfo[5]= status;
				
				result[i] = bookInfo;
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
