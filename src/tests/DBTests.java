package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import queryTools.QueriesRealisation;

public class DBTests {

	public static void main(String[] args) throws ClassNotFoundException,
		SQLException, InterruptedException{
		
		String userName = "evgeny";
		String password = "123456";
		String url = "jdbc:mysql://localhost/supplies?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, userName, password);				
			System.out.println("connected");
			String str = "show_shippings";
			
			QueriesRealisation qr = new QueriesRealisation();
			//qr.show(con, str);
		} catch (SQLException e) {
			System.out.println("cant connect to db");
			e.printStackTrace();
		} finally {
			if (con != null) con.close();				
			System.out.println("db disconnected");
		}
	}
}
