import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DataBase {

	public static void InsertData(int RollNo, String name, String DoB, int age, String grade, String city, String phno) {
		
		Student s1 = new Student(RollNo, name, DoB, age, grade, city, phno, "");
		try{
				//Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
				//creating connection
			Connection con = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:XE","dimple","1212");
			Statement s=con.createStatement();	//creating statement

				//ResultSet rs=s.executeQuery("select * from STUDENT");	//executing statement
				
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
			
			ResultSet rs = s.executeQuery("select * from student");
			
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

	public static void EstablishingJDBC() {
		try{
			//Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");		
			
				//creating connection
			Connection con = DriverManager.getConnection
				                     ("jdbc:oracle:thin:@localhost:1521:XE","dimple","1212");
				
			Statement s=con.createStatement();	//creating statement
				
			ResultSet rs=s.executeQuery("select * from STUDENT");	//executing statement
				
			while(rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + 
				" " + rs.getString(5) + " " + rs.getString(6) + " " +  rs.getString(7) + " " + rs.getString(8));
			}
				
			con.close();	//closing connection
		}
		catch(Exception e){
		}
	}
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello Welcome to JDBC! \nExisting Data in Table STUDENT is: \n");
		EstablishingJDBC();
		
		System.out.println("Enter your choice to do operation on table: ");
		System.out.println("Enter 1 to INSERT data into table.");
		System.out.println("Enter 2 to UPDATE data into table.");
		System.out.println("Enter 3 to DELETE data into table.");
		System.out.println("Enter 4 to EXIT ");
		
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1:
			int RollNo = scan.nextInt();
			String name = scan.next();
			String DoB = scan.next();
			int age = scan.nextInt();
			String grade = scan.next();
			String city = scan.next();
			String phno = scan.next();
			InsertData(RollNo, name, DoB, age, grade, city, phno);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			System.out.println("Thankyou!");
			break;
		default:
			System.out.println("Invalid Choice! Select a valid choice: ");
		}
	}
}