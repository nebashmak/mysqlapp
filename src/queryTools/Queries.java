package queryTools;

import java.sql.Connection;

public interface Queries {
	void add(Connection con, String[] str);
	
	void delete(Connection con, String[] str);
	
	void show(Connection con, String[] table);
}
