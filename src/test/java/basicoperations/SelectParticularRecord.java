package basicoperations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectParticularRecord 
{
	public static void main(String[] args) 
	{
		final String FQN="com.mysql.cj.jdbc.Driver";
		final String URL="jdbc:mysql://localhost:3310/asian?user=root&password=root";
		final String QUERY="select eno,esal from employee";
		try
		{
			Class.forName(FQN);
			Connection connection=DriverManager.getConnection(URL);
			Statement statement =connection.createStatement();
			statement.execute(QUERY);
			ResultSet resultset=statement.getResultSet();
			boolean check=false;
			while(resultset.next())
			{
				check=true;
				System.out.println(resultset.getInt("eno")+"  "+resultset.getDouble("esal"));
			}
			if(!check)
			{
				System.out.println("No Records Found");
			}
			connection.close();
			resultset.close();
			statement.close();
		}
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();// TODO: handle exception
		}
	}
}
