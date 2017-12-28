package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbManager {
	static Connection connection;

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "ProgrammingSchool";
		String userName = "root";
		String password = "coderslab";

		try {
			if ((connection == null) || (connection.isClosed())) {
				connection = DriverManager.getConnection(url + dbName + "?useSSL=false", userName, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}
	
	public static PreparedStatement getPreparedStatement(String sql, String[] columns){
		try {
			return getConnection().prepareStatement(sql, columns);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
return null;
	}

}
