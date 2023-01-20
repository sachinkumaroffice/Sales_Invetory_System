package com.sis.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	Connection con = null;
	
	public void connectToDB() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.DBURL, IPathConstants.DBUSERNAME, IPathConstants.DBPASSWORD);
		
	}
	public String executeQueryAndgetData(String query, int columnIndex, String expData) throws Throwable {
		 ResultSet result = con.createStatement().executeQuery(query);
		 boolean flag = false;
		 while (result.next()) {
			String data = result.getString(columnIndex);
			System.out.println(data);
			if (data.equalsIgnoreCase(expData)) //Comparing {
				flag = true;
			break;
			}
		 if (flag) {
			System.out.println(expData+"Project is Created");
			return expData;
		} else {
			System.out.println("Project not created");
			return " ";
		}
		
	}
	public void closeDBConnection() throws Throwable {
		con.close();
		
	}
}
