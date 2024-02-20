package basicoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSingleRecord {
	public static void main(String[] args) {
		final String FQN = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3310/asian";
		final String USERNAME = "root";
		final String PASSWORD = "root";
		final String QUERY = "insert into employee values(601,'shubham puri',78500.00,'Pune')";
		try {
			Class.forName(FQN);
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			statement.executeUpdate(QUERY);
			System.out.println("Data Inserted Successfully");
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
