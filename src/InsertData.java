import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		int RollNo = scan.nextInt();
		String name = scan.next();
		String DoB = scan.next();
		int age = scan.nextInt();
		String grade = scan.next();
		String city = scan.next();
		String phno = scan.next();
		
		Student s1 = new Student(RollNo, name, DoB, age, grade, city, phno, "");
		System.out.println(s1.getCreationDate());
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:XE","dimple","1212");
			
			Statement s=con.createStatement();	//creating statement

			
			PreparedStatement pst=con.prepareStatement("insert into Student values(?,?,?,?,?,?,?,?)");	
			pst.setInt(1,s1.getRollNo());
	        pst.setString(2, s1.getName());
	        pst.setString(3, s1.getDOB());
	        pst.setInt(4, s1.getAge());
	        pst.setString(5,s1.getGrade());
			pst.setString(6, s1.getCity());
	        pst.setString(7, s1.getPhoneNo());
	        pst.setString(8, s1.getCreationDate());
	        pst.executeUpdate();
		 
	        int x = pst.executeUpdate(); 
            if (x > 0)             
                System.out.println("Successfully Inserted");             
            else            
                System.out.println("Insert Failed"); 
              
	        ResultSet rs = pst.executeQuery("select * from student where rollno is :" );

	        while(rs.next()){
	        	System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " +  
	        rs.getInt(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " +  rs.getString(7) + " " + 
	        rs.getString(8));
	        }	

	        con.close();	//closing connection
		}
		catch(Exception e){
				System.out.println(e);
		}
		
	}
}
