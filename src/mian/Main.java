package mian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import queryTools.Queries;
import queryTools.QueriesRealisation;


public class Main {
/**
 * 
 * @author Evgeny
 * This is application starter, 
 * Functions:
 * - reading commands from console
 * - get connection with DB
 */
	public static void main(String[] args) {
		String userName = "evgeny";
		String password = "123456";
		String url = "jdbc:mysql://localhost/supplies?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		CommandsParser parser = new Parser();
		Queries qMaster = new QueriesRealisation();
		
		System.out.println("Hello pls type your command");
		
		try(BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));
				Connection con = DriverManager
						.getConnection(url, userName, password)) {
			String str = null;
			while (!"exit".equals(str = reader.readLine())) {// Finish the app if enter command = "exit"
				String command[] = parser.parse(str);
				if(command != null) {
					if(command[0].startsWith("add_")) {
						qMaster.add(con, command);
					} else if (command[0].startsWith("delete_")) {
						qMaster.delete(con, command);
					} else if (command[0].startsWith("show_")) {
						qMaster.show(con, command);
					} else System.out.println("unknown command");
				} else {
					System.out.println("unknown command");
				}				
			}
			System.out.println("goodbye");
		} catch (IOException e) {
			System.out.println("Connection with console error");
		} catch (SQLException e1) {
			System.out.println("Error connection with DB");
		}
	}
}
