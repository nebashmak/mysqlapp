package queryTools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueriesRealisation implements Queries {
	Statement statement = null;
	
	/**Need to change this method
	 * make it more simple.
	 * Branch "delete_shapes" need to be useful insert only start_date
	 * without end_date and check start_date < end_date
	 */
	@Override
	public void add(Connection con, String[] str) {
		
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
		} else {
			System.out.println("unknown kommand");			
		}
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
		} else if ("delete_town".equals(str[0])) {
			s1 = "TOWNS";
			s2 = "town_id = " + str[1];
		} else if ("delete_shipping".equals(str[0])) {
			s1 = "SHIPPINGS";
			s2 = "shipping_id = " + str[1];			
		} else {
			System.out.println("unknown commnad");
			return;
		}
		
		query = String.format(pattern, s1, s2);
		try {
			statement = con.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement != null) statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void show(Connection con, String[] table) {
		String pattern = "SELECT * FROM %s;";
		String label = null;
		String s1 = null;
		String sql = null;
		ResultSet rs = null;
		
		if ("show_items".equals(table[0])) {
			s1 = "ITEMS";
			label = "item_id  item_name            quantity\n"
					+ "--------------------------------------";
		} else if ("show_towns".equals(table[0])) {
			s1 = "TOWNS";
			label = "town_id  town_name            distance\n"
					+ "--------------------------------------";
		} else if ("show_shippings".equals(table[0])) {
			s1 = "SHIPPINGS";
			label = "ship_ip  item_id  town_id  start_date   end_date\n"
					+ "--------------------------------------------------";
			try {
				statement = con.createStatement();
				sql = String.format(pattern, s1);
				rs = statement.executeQuery(sql);
				System.out.println(label);
				while (rs.next()) {
					int id = rs.getInt(1);
					int item_id = rs.getInt(2);
					int town_id = rs.getInt(3);
					String startd = rs.getDate(4).toString();
					String endd = rs.getDate(5).toString();
					
					System.out.printf("%-8d %-8d %-8d %-12s %-12s%n",
							id, item_id, town_id, startd, endd);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null) statement.close();
					return;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("unknown command");
			return;
		}
		sql = String.format(pattern, s1);
		
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			System.out.println(label);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int number = rs.getInt(3);
				System.out.printf("%-8d %-20s %d%n", id, name, number);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
}
