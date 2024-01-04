package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
	public static Connection makeConn() {//db연결됨
		String url = "jdbc:mysql://localhost/bookrental";
		
		Connection con = null;
		String id = "root";
		String pw = "";
		
		try {
			con = DriverManager.getConnection(url, id, pw);
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}

}