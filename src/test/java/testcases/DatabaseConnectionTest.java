package testcases;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import base.DatabaseConnection;

public class DatabaseConnectionTest {

	public DatabaseConnection dbConnection;
	
	@Test
	public void showEmployee() throws ClassNotFoundException, SQLException,Exception {
		
		dbConnection = new DatabaseConnection();
		dbConnection.connectDatabase();
		String tableName="Employees";
		
		ResultSet rs = dbConnection.getTable(tableName);

		while (rs.next()){
    		String myName = rs.getString(1);								        
            String myAge = rs.getString(2);					                               
            System. out.println(myName+"  "+myAge);
		}
		
		dbConnection.closeConnect();
	}
	
}
