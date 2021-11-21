package com.raystech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcpreparedstatement {
	

	public static void main(String[] args) throws Exception {
		// addinsert();
		//addupdate();
		// adddelete();
		addselect();
	}

	private static void addselect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");
		
		
		//PreparedStatement ps = conn.prepareStatement("select fname, lname from employee where id=?");
		
		PreparedStatement ps = conn.prepareStatement("select * from employee");
		//ps.setInt(1, id);
		//ps.setString(2, fname);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.print(" \t  " + rs.getInt(1));
			System.out.print(" \t  " + rs.getString(2));
			System.out.print("\t "+rs.getString(3));
			System.out.print("\t "+rs.getInt(4));
			System.out.println("\t  "+rs.getInt(5));
		}
	}

	private static void adddelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");
		int ID = 7;
		PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, ID);
		int i = ps.executeUpdate();
		System.out.println(i + "deleted");
		conn.close();
		ps.close();

	}

	private static void addupdate() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");
		int id = 10;
		String FNAME = "VISHAL";
		String LNAME = "VARMA";
		int SALARY = 22222;
		int DEPT_ID = 5;

		PreparedStatement ps = conn
				.prepareStatement("UPDATE EMPLOYEE SET FNAME=?, LNAME=?, SALARY=?,DEPT_ID=? WHERE id=?");

		ps.setString(1, FNAME);
		ps.setString(2, LNAME);
		ps.setInt(3, SALARY);
		ps.setInt(4, DEPT_ID);
		ps.setInt(5, id);

		int i = ps.executeUpdate();
		System.out.println("UPDATED");

	}

	private static void addinsert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays", "root", "root");
		int id = 10;
		String FNAME = "harsh";
		String LNAME = "upadhyay";
		int SALARY = 5000;
		int DEPT_ID = 3;

		PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, FNAME);
		ps.setString(3, LNAME);
		ps.setInt(4, SALARY);
		ps.setInt(5, DEPT_ID);

		int i = ps.executeUpdate();
		conn.close();
		ps.close();

	}
}
