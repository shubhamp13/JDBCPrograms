package basicoperations;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DeleteRecord 
{
	public static void main(String[] args) 
	{
		String FQN="com.mysql.cj.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3310/asian?user=root&password=root";
		String QUERY="delete from employee where esal=60000";
		try
		{
			 
			Class.forName(FQN);
			Connection connection=DriverManager.getConnection(URL);
			Statement statement=connection.createStatement();
			int rows=statement.executeUpdate(QUERY);
			System.out.println("No Of Rows Updated: "+rows);
			System.out.println("Record Deleted Successfully");
			statement.close();
			connection.close();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
