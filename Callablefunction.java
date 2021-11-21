package com.raystech.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Callablefunction {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");
		CallableStatement callstmt	=conn.prepareCall("{?=CALL markfunc(?,?)}");
		callstmt.registerOutParameter(1, Types.INTEGER);
		callstmt.setString(2, "sonu");
		callstmt.setInt(3, 100);
		callstmt.execute();
		System.out.println(callstmt.getInt(1));	
	}
}
