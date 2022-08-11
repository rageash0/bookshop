package bookshop.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccessObject {

	//MySQL Driver
	final private static String driver = "com.mysql.cj.jdbc.Driver";
	//Database
	final private static String url = "jdbc:mysql://localhost:3306/bookshop";
	final private static String username = "root";
	final private static String password = "admin";

	public Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
}
