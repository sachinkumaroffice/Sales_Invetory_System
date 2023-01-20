package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataInProject {
public static void main(String[] args) throws SQLException {
	        Connection con=null;
	        int result = 0;
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
	 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	       Statement state = con.createStatement();
	       String query = "insert into project values('Proj_87', 'Abcd', '21/12/2022', 'SIS', 'In-Progress', 3)";
	       result = state.executeUpdate(query);
	       System.out.println(result);
		
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
