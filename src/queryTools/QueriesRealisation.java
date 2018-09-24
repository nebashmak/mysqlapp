package queryTools;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class QueriesRealisation implements Queries {

	@Override
	public void add(Connection con, String[] str) {
		Statement statement = null;
		if ("add_item".equals(str[0])) {
			try {
				String quary = String.format("INSERT INTO ITEMS "
						+ "(item_name, quantity) VALUES "
						+ "('%s', '%s');", str[1], str[2]);
				
				statement = con.createStatement();
				statement.executeUpdate(quary);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null) statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else if ("add_town".equals(str[0])) {
			try {
				String quary = String.format("INSERT INTO TOWNS "
						+ "(town_name, distance) VALUES "
						+ "('%s', '%s');", str[1], str[2]);
				
				statement = con.createStatement();
				statement.executeUpdate(quary);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null) statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else if ("add_shipping".equals(str[0])) {
			try {
				String quary = String.format("INSERT INTO SHIPPINGS "
						+ "(item_id, town_id, start_date, end_date) VALUES "
						+ "('%s', '%s', '%s', '%s');",
						str[1], str[2], str[3], str[4]);
				statement = con.createStatement();
				statement.executeUpdate(quary);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null) statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else System.out.println("unknown kommand");
	}

	@Override
	public void delete(Connection con, String[] str) {
		String pattern = "DELETE FROM %s WHERE %s;";
		String s1 = null;
		String s2 = null;
		String query = null;
		
		if ("delete_item".equals(str[0])) {
			s1 = "ITEMS";
			s2 = "item_id = " + str[1];
			query = String.format(pattern, s1, s2);
		}
		Statement statement = null;
		try {
			statement = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	@Override
	public void show(Connection con, String table) {
		// TODO Auto-generated method stub
		
	}
	
}
