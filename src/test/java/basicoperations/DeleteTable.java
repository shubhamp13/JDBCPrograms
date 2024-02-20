package basicoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTable {
	public static void main(String[] args) {
		String query = "drop table teacher";
		String fullyQualifiedClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3310/asian";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(fullyQualifiedClassName);
			Connection connection = DriverManager.getConnection(url, userName, password);
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Table Deleted Successfully");
			connection.close();
			statement.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
