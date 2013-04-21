package com.joonsubtalk.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection(DBType.MYSQL);
			stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmnt.executeQuery("SELECT stateId, stateName FROM states");
			rs.last();
			System.out.println("Connected with " + rs.getRow() + " states.");
		} catch (SQLException e) {
			DBUtil.processException(e);
		} finally {
			if (rs != null)
				rs.close();
			if (stmnt != null)
				stmnt.close();
			if (conn != null)
				conn.close();
		}
	}

}
