package com.raystech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc {
	public static void main(String[] args) throws Exception {
		addselect();
		// addinsert();
		//adddelete();		
	}
	private static void adddelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root","root");
		Statement stmt=conn.createStatement();
		int rs=stmt.executeUpdate("DELETE FROM EMPLOYEE WHERE ID=7");
		System.out.println(rs + "deleted");	
	}

	private static void addinsert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");
		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(8, 'AKANKSHA', 'RAWAL' ,22000 , 2)");
		System.out.println(rs + "inserted");
	}

	private static void addselect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT*FROM EMPLOYEE");
		while (rs.next()) {
			System.out.print(" \t   " + rs.getInt(1));
			System.out.print(" \t   " + rs.getString(2));
			System.out.print(" \t   " + rs.getString(3));
			System.out.print(" \t   " + rs.getInt(4));
			System.out.println(" \t " + rs.getInt(5));
		}
		stmt.close();
		conn.close();
	}

}
