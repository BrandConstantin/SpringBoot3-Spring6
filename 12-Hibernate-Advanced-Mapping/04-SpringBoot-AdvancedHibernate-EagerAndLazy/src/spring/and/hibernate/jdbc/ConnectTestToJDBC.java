package spring.and.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTestToJDBC {
	public static void main(String[] args) {
		Connection myConn = null;		
		
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
			String user = "springstudent";
			String pass = "springstudent";
			
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
