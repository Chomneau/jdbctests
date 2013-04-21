package com.joonsubtalk.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpass";
	private static final String CONN_STRING = 
			"jdbc:mysql://localhost/explorecalifornia";//localhost may be a ipaddress/dns
	
	public static Connection getConnection(DBType dbtype) throws SQLException{
		switch (dbtype){
		case MYSQL:
			return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD); 
		default:
			return null;
		}
	}
	
	public static void processException(SQLException e){
		System.err.println("Error message" + e.getMessage());
		System.err.println("Error code" + e.getErrorCode());
		System.err.println("Error sqlstate " + e.getSQLState());
	}
}
