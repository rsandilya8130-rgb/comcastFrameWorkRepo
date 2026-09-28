package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	Connection connect;

	public void getConnection(String url, String un, String pwd) throws SQLException {
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			connect = DriverManager.getConnection(url, un, pwd);
		} catch (Exception e) {
			System.out.println("Exception Handled...");
		}
	}

	public void getConnection() throws SQLException {
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Thakurji8130");
		} catch (Exception e) {
			System.out.println("Exception Handled...");
		}
	}

	public void closeConnection() throws SQLException {
		try {
			connect.close();
		} catch (Exception e) {
		}
	}

	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result = null;
		try {
			Statement statement = connect.createStatement();
			result = statement.executeQuery(query);
		} catch (Exception e) {

		}
		return result;
	}

	public int executeNonSelectQuery(String query) {
		int value = 0;
		try {
			Statement statement = connect.createStatement();
			value = statement.executeUpdate(query);
		} catch (Exception e) {

		}
		return value;

	}
}
