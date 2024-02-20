package basicoperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecordDynamic 
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
			System.out.println("Enter Empno to delete the record");
			int empNo=Integer.parseInt(bufferReader.readLine());
			String query="delete from employee where eno="+empNo;
			int rows=statement.executeUpdate(query);
			System.out.println("No Of Rows Affected:"+rows);
			bufferReader.close();
			statement.close();
			connection.close();
		}
		catch (IOException |ClassNotFoundException|SQLException e) 
		{ 
			e.printStackTrace();
		}
	}
}
