package basicoperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleRecords 
{
	public static void main(String[] args) 
	{
		BufferedReader bufferReader=new BufferedReader(new InputStreamReader(System.in));
		final String FQN="com.mysql.cj.jdbc.Driver";
		final String URL="jdbc:mysql://localhost:3310/asian?user=root&password=root";
		
			try
			{
				Class.forName(FQN);
				Connection connect=DriverManager.getConnection(URL);
				Statement statement=connect.createStatement();
				while(true)
				{
					System.out.println("Enter Emp No:");
					int empNo=Integer.parseInt(bufferReader.readLine());
					System.out.println("Enter Emp Name:");
					String empName=bufferReader.readLine();
					System.out.println("Enter Employee Salary");
					double esal=Double.parseDouble(bufferReader.readLine());
					System.out.println("Enter Employee Address");
					String address=bufferReader.readLine();
					statement.executeUpdate("insert into employee values("+empNo+",'"+empName+"',"+esal+",'"+address+"')");
					System.out.println("Record Inserted Successfully");
					System.out.println("Do You Want to Insert Yes or No");
					String ch=bufferReader.readLine();
					if(ch.equalsIgnoreCase("no"))
					{
						break;
					}
						
				}
				statement.close();
				connect.close();
				bufferReader.close();
				
			}catch (ClassNotFoundException | SQLException | IOException e) 
			{
				e.printStackTrace();
			}
			System.out.println("Completed");
	}
}
