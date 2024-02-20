package basicoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) 
	{
		String query="create table employee(eno int,ename varchar(20),esal double,eaddr varchar(50))";
		String fullyQualifiedClassName="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3310/asian?user=root&password=root";
		try
		{
			Class.forName(fullyQualifiedClassName);
			Connection connection=DriverManager.getConnection(url);
			Statement statement=connection.createStatement();
			statement.executeUpdate(query);
			connection.close();
			statement.close();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
