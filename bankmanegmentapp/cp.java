package bankmanegmentapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class cp {
	static Connection con;

	public static Connection createC() {
		try {
			// load the driver....
			Class.forName("com.mysql.jdbc.Driver");

			// create a connection....
			String url = "jdbc:mysql://localhost:3306/bankmanegment";
			String username = "root";
			String password = "piyush";
			con = DriverManager.getConnection(url, username, password);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection Problem......");
		}
		return con;

	}
	
	
	

}
