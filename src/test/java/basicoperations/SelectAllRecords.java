package basicoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllRecords 
{
	public static void main(String[] args) 
	{
		final String FQN="com.mysql.cj.jdbc.Driver";
		final String URL="jdbc:mysql://localhost:3310/asian?user=root&password=root";
		final String QUERY="select * from employee";
		try
		{
			Class.forName(FQN);
			Connection connection=DriverManager.getConnection(URL);
			Statement statement=connection.createStatement();
//			statement.execute(QUERY);
//			ResultSet resultset=statement.getResultSet();
			ResultSet resultset=statement.executeQuery(QUERY);
			boolean b=false;
			while(resultset.next())
			{
				b=true;
				System.out.println(resultset.getInt(1)+"   "+resultset.getString(2)+"   "+resultset.getDouble(3)+"  "+resultset.getString(4));
			}
			if(!b)
			{
				System.out.println("No Record Found");
			}
			resultset.close();
			statement.close();
			connection.close();
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
