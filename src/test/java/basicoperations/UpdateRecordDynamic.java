package basicoperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecordDynamic 
{
	public static void main(String[] args) 
	{
		String FQN="com.mysql.cj.jdbc.Driver";	
		String URL="jdbc:mysql://localhost:3310/asian?user=root&password=root";
		try
		{
			BufferedReader bufferReder=new BufferedReader(new InputStreamReader(System.in));
			Class.forName(FQN);
			Connection connection=DriverManager.getConnection(URL);
			Statement statement=connection.createStatement();
			System.out.println("Enter Employee No");
			int empno=Integer.parseInt(bufferReder.readLine());
			System.out.println("Enter New Updated Employee Salary");
			double esal=Double.parseDouble(bufferReder.readLine());
			statement.executeUpdate("update employee set esal="+esal+" where eno="+empno+";");
			statement.close();
			connection.close();
			bufferReder.close();
		}
		catch (SQLException | IOException  | ClassNotFoundException e) 
		{
			 e.printStackTrace();
		}
	}
}
