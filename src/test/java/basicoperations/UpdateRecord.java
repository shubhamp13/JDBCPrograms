package basicoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class UpdateRecord 
{
	public static void main(String[] args) 
	{
		final String FQN="com.mysql.cj.jdbc.Driver";
		final String URL="jdbc:mysql://localhost:3310/asian";
		final String user="root";
		final String pass="root";
		final String QUERY="update employee set esal=100000 where eno=601";
		try
		{
			Class.forName(FQN);
			Connection connection=DriverManager.getConnection(URL,user,pass);
			Statement statement=connection.createStatement();
			int rows=statement.executeUpdate(QUERY);
			System.out.println("No Of Rows Affected:"+rows);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			 e.printStackTrace();
		}
	}
}
