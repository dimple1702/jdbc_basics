import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteOperation {
	public static void main(String args[]){
		String id = "639";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "dimple", "1212");
		
			PreparedStatement pst = con.prepareStatement("select * from student where ROLLNO = ?");
			pst.setString(1, id);
		
			ResultSet rs = pst.executeQuery(); 
            if (rs.next()) 
            { 
            	System.out.println("Deleted row is: ");
            	System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " +  
            	rs.getInt(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " +  rs.getString(7) + " " + 
            	rs.getString(8));
            } 
            else
            { 
                System.out.println("No data is found to be deleted!"); 
            } 
            con.close(); 
        } 
        catch(Exception e) 
        { 
            System.out.println(e); 
        } 
	}
}
