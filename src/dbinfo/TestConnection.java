package dbinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import queryTools.QueriesRealisation;

public class TestConnection {

	public static void main(String[] args) throws ClassNotFoundException,
		SQLException, InterruptedException{
		
		String userName = "evgeny";
		String password = "123456";
		String url = "jdbc:mysql://localhost/supplies?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection	con = null;
		
			try {
				con = DriverManager.getConnection(url, userName, password);				
				System.out.println("connected");
				String[] str = new String[5];
				str[0] = "add_shipping";
				str[1] = "54";
				str[2] = "1";
				str[3] = "2002-12-12";
				str[4] = "";
				QueriesRealisation qr = new QueriesRealisation();
				qr.add(con, str);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("cant connect to db");
				e.printStackTrace();
			} finally {
				if (con != null) con.close();
				
				System.out.println("db disconnected");
			}		
	}
}
