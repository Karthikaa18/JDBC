package com.Actions;
import java.sql.*;

public class MyClass {
	static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://localhost/database1";
	static final String USER = "username";
	static final String PASS = "password";
	
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			System.out.println("Creating Statement..");
			stmt=conn.createStatement();
			String sql= "SELECT User ID,First Name,Last Name,Email ID FROM new_table";
		
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
			
					int UserID = rs.getInt("User ID");
					String FirstName = rs.getString("First Name");
					String LastName = rs.getString("Last Name");
					String EmailID = rs.getString("Email ID");
					
					System.out.println("UserID:" +UserID);
					System.out.println("First Name:" +FirstName);
					System.out.println("Last Name:" +LastName);
					System.out.println("Email ID:" +EmailID);
				}
			rs.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)
					conn.close();
			}catch(SQLException se) {
			}
			try {
				if(conn!=null)
					conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Completed");

	}

}