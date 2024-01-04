package Delete.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import Db.Connector;

public class DeleteRepo {
	public static boolean delete(int no) {
		boolean isSuccess = false;
		Connection conn = Connector.makeConn();
		//정말로 "DELETE FROM book WHERE `book`.`no` = 13"을/를 실행하시겠습니까?
		//StringBuilder sql = new StringBuilder(); //하나의 값만 받으 때는 build 사용 안해도 됨
		String sql1 = "DELETE FROM book WHERE `book`.`no` = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql1.toString());
			ps.setInt(1, no);
			
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