package com.joonsubtalk.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpass";
	private static final String CONN_STRING = 
			"jdbc:mysql://localhost/explorecalifornia";//localhost may be a ipaddress/dns
	public static void main(String[] args) throws SQLException {
		//Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmnt.executeQuery("SELECT * FROM states");
			rs.last();
			System.out.println("Connected with " + rs.getRow() + " states.");
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (conn != null)
				conn.close();
		}
	}

}
