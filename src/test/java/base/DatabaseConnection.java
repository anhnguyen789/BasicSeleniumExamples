package base;



import  java.sql.Connection;		
import  java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;	

public class DatabaseConnection {
	
	  private String dbUrl = "jdbc:mysql://localhost:3306/demo_selenium";					

		//Database Username		
		private  String username = "root";	
     
		//Database Password		
		private  String password = "123456";				
		private  Connection con;
			
		@BeforeClass
		public void connectDatabase()  throws ClassNotFoundException, SQLException, Exception {			
			try {
				this.con = (Connection) DriverManager.getConnection(dbUrl,username,password);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}	
		   
		    
		}
		
		@AfterClass
		public void closeConnect() throws ClassNotFoundException, SQLException{
			con.close();
			
		}
		
		
		public ResultSet getTable(String tableName ) throws ClassNotFoundException, SQLException, Exception{
			try {
				//Query to Execute		
				String query = "select *  from "+tableName+";";			     
			    //Load mysql jdbc driver		
			    Class.forName("com.mysql.jdbc.Driver");							
				//Create Statement Object		
			    Statement stmt = (Statement)con.createStatement();						
				// Execute the SQL Query. Store results in ResultSet						
			    return  stmt.executeQuery(query);	
		    
			}catch (Exception e) {		
		    	System.out.println(e.getStackTrace());
		    	return null;
		    	
			}
		}
		
		
		
			

}
