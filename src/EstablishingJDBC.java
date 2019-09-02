import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EstablishingJDBC {
	public static void main(String args[]) {
		try{
		//Loading driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//creating connection
		Connection con = DriverManager.getConnection
		                     ("jdbc:oracle:thin:@localhost:1521:XE","dimple","1212");
		
		Statement s=con.createStatement();	//creating statement
		
		ResultSet rs=s.executeQuery("select * from STUDENT");	//executing statement
		
		while(rs.next()){
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " +  
			        rs.getInt(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " +  rs.getString(7) + " " + 
			        rs.getString(8));
		}
		
		con.close();	//closing connection
		}
		catch(Exception e){
		}
	}
}