  package DDT_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Get_DataFromMySql {
	public static void main(String[] args) throws SQLException {
		Connection connect = null;
		try {
			
		// Step 1 : load / register the database driver
		Driver driverRef = new Driver(); // driver form mysql.jdbc.Driver
		DriverManager.registerDriver(driverRef);
		// Step 2 : connect to database
		 connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Thakurji8130");
		System.out.println("======Done======");
		// Step 3 : create Sql statement
		Statement state = connect.createStatement();
		// Step 4 : create select query and get result
		ResultSet result = state.executeQuery("select * from actor");
		 while(result.next()) {
			 System.out.println(result.getInt(1)+"\t"+result.getString(2) +"      " + result.getString(3));
		 }
		}catch(Exception e) {
			System.out.println("handle exception");
		}finally {
		// Step 5 : close the connection
		connect.close();
		System.out.println("DataBase Closed");
		}
	}

}
