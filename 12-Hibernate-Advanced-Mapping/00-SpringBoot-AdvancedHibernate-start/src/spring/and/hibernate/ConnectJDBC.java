package spring.and.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectJDBC {
	public static void main(String[] args) {
		Connection myConn = null;		
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
			String user = "hbstudent";
			String pass = "hbstudent";
			
			System.out.println("Connecting to database " + jdbcUrl);

			myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			if(myConn != null) {
				System.out.println("Successful connection to !! " + myConn);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
