package com.raystech.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLType;
import java.sql.Types;

public class Callablestatement {
public static void main(String[] args) throws Exception {
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root","root");
	CallableStatement callstmt	=conn.prepareCall("{CALL emp_count(?)}");
	callstmt.registerOutParameter(1, Types.INTEGER);
	callstmt.execute();
	int count= callstmt.getInt(1);
	System.out.println(count); 
	
}
}
