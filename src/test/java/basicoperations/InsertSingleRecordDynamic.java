package basicoperations;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSingleRecordDynamic 
{
	public static void main(String[] args) 
	{
		String FQN = "com.mysql.cj.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3310/asian";
		String USERNAME = "root";
		String PASSWORD = "root";

		try 
		{
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter Name of An Employee:");
			final String ename = bufferReader.readLine();

			System.out.println("Enter Employee No:");
			final int empNo = Integer.parseInt(bufferReader.readLine());

			System.out.println("Enter Employee Salary");
			final double empSal = Double.parseDouble(bufferReader.readLine());

			System.out.println("Enter Employee Address:");
			final String address = bufferReader.readLine();

			final String query = "insert into employee values(" + empNo + ",'" + ename + "'," + empSal + ",'" + address
					+ "'s)";

			Class.forName(FQN);
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Data Inserted Successfully");
			statement.close();
			connection.close();
			bufferReader.close();

		} catch (IOException | ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
