package DDT_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class CheckProjectInBackEndMysql {

	@Test
	 public void actorCheckTest() throws SQLException {
		String expectedActorname = "Rahul";
		boolean flag = false;
		// Step 1 : load / register the database driver
				Driver driverRef = new Driver(); // driver form mysql.jdbc.Driver
				DriverManager.registerDriver(driverRef);
				// Step 2 : connect to database
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "Thakurji8130");
				System.out.println("======Done======");
				// Step 3 : create Sql statement
				Statement state = connect.createStatement();
				// Step 4 : create select query and get result
				ResultSet result = state.executeQuery("select * from actor");
				 while(result.next()) {
					String actActorName = result.getString(2);
					if(expectedActorname.equals(actActorName)) {
						flag = true;
						System.out.println(expectedActorname+ " is available == Pass ");
						break;
					}
	 			 }
				 if(flag==false) {
						System.out.println(expectedActorname+ " is not available == fale ");
						
					}
				// Step 5 : close the connection
				connect.close();
	}
}
