import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Student {
	private int ROLLNO;
	private String NAME;
	private String DOB;
	private int AGE;
	private String GRADE;
	private String CITY;
	private String PHONENO;
	private String CREATIONDATE;
	
	public Student(int ROLLNO, String NAME, String DOB, int AGE, String GRADE, String CITY, String PHONENO, String CREATIONDATE) {
		this.ROLLNO = ROLLNO;
		this.NAME = NAME;
		this.DOB = DOB;
		this.AGE = AGE;
		this.GRADE = GRADE;
		this.CITY = CITY;
		this.PHONENO = PHONENO;
		this.CREATIONDATE = CREATIONDATE;
	}

	public int getRollNo() {
		return ROLLNO;
	}
	public String getName() {
		return NAME;
	}
	public String getDOB() {
		return DOB;
	}
	public int getAge() {
		return AGE;
	}
	public String getGrade() {
		return GRADE;
	}
	public String getCity() {
		return CITY;
	}
	public String getPhoneNo() {
		return PHONENO;
	}
	public String getCreationDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
  		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
}
