package basicoperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SelectRecordsBasedOnSal 
{
	public static void main(String[] args) 
	{
		final String FQN="com.mysql.cj.jdbc.Driver";
		final String URL="jdbc:mysql://localhost:3310/asian?user=root&password=root";
		try
		{
			BufferedReader bufferReader=new BufferedReader(new InputStreamReader(System.in));
			Class.forName(FQN);	
			Connection connection=DriverManager.getConnection(URL);
			Statement statement=connection.createStatement();
			System.out.println("Enter Range of Salary");
			double sal=Double.parseDouble(bufferReader.readLine());
			String query="select * from employee where esal>"+sal;
			ResultSet resultset=statement.executeQuery(query);
			boolean check=false;
			while(resultset.next())
			{
				check=true;
				System.out.println(resultset.getInt(1)+"  "+resultset.getString(2)+resultset.getDouble(3)+resultset.getString(4));
			}
			if(!check)
			{
				System.out.println("Records Not Found");
			}
			statement.close();
			resultset.close();
			connection.close();
			bufferReader.close();
		}
		catch (SQLException |ClassNotFoundException | IOException e) 
		{
			e.printStackTrace();// TODO: handle exception
		}
	}
}
