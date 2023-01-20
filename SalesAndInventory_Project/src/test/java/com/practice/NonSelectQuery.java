   package com.practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {
public static void main(String[] args) throws SQLException {
	Connection con = null;
	int result = 0;
	    
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement state = con.createStatement();
		String query = "insert into studentInfo values('Frank Underwood', 'USA', 'SDET', 12);";
		result = state.executeUpdate(query);
	} catch (Exception e) {
		// TODO: handle exception
	}
	finally {
		if (result==1) {
			System.out.println("Data inserted successfully");
		} else {
         System.out.println("Data not inserted");
		}
		con.close();
		
	}
}
}
