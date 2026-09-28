package DDT_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryInMysql {

	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Thakurji8130");
		Statement state =  connect.createStatement();
		int result = state.executeUpdate("insert into actor values('202', 'Rahul','Sandilya','2006-08-31 12:10:45');");
		System.out.println(result);
		connect.close();

	}

}
