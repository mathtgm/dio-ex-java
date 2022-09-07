package br.com.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		if(connection != null) {
			return connection;
		}
		
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/consultorioDB", "postgres", "123");
	}
}
