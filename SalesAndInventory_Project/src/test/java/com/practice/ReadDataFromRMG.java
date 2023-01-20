package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromRMG {
public static void main(String[] args) throws SQLException {
	Connection con = null;
	
	try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query = "select * from projects";
		ResultSet result = state.executeQuery(query);
	} catch (Exception e) {
		// TODO: handle exception
	}
	finally {
		con.close();
	}
}
}
