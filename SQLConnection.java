import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.Date;  
import java.text.SimpleDateFormat;  

public class SQLConnection{
	
	
	
	public static void main(String[] args)
	{
		
		String table = "";
		String account = "";
		String name = "";
		String start = "";
		String location = "";
		String bio = "";
		String row1 = "";
		String row2 = "";
		String row3 = "";
		String row4 = "";
		String row5 = "";
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Scanner myObj = new Scanner(System.in);
		String firstSQL = "";
		String secondSQL = "";
		String answer = "";
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection connection = DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/Twitter","root","root");    
		//long length = SQLCOUNT();
		Statement database = connection.createStatement();
		System.out.println("Do you want to create a new table?");
		Scanner input = new Scanner(System.in);
		String ans = input.nextLine();
		if(ans.equals("yes") == true || ans.equals("Yes") == true)
		{
			System.out.println("Please enter the name of the table");
			input1 = new Scanner(System.in);
			table = input1.nextLine();
			System.out.println("Please enter the names of the four rows");
			input2 = new Scanner(System.in);
			row1 = input2.nextLine();
			input2 = new Scanner(System.in);
			row2 = input2.nextLine();
			input2 = new Scanner(System.in);
			row3 = input2.nextLine();
			input2 = new Scanner(System.in);
			row4 = input2.nextLine();
			input2 = new Scanner(System.in);
			row5 = input2.nextLine();
			 
			/**
			CREATE TABLE Twitter(
			FirstName Number(20), 
			UserName VarChar2(20), 
			Location VarChar(20),
			Bio VarChar2(300),
			StartDate VarChar2(20));
			**/
			database.executeUpdate("CREATE TABLE " + table + " (" + row1 + " VarChar2(20)," + row2 + " VarChar2(20)," + row3 + " VarChar(20)," + row4 + " VarChar(300)," + row5 + " VarChar(20))");
		}
		System.out.println("What would you like to do?");
		input = new Scanner(System.in);
		ans = input.nextLine();
		if(ans.equals("Insert") == true || ans.equals("insert") == true)
		{
			
		System.out.println("Please enter the name of the table");
		input1 = new Scanner(System.in);
		table = input1.nextLine();
		System.out.println("Please enter the names of the five rows");
		input2 = new Scanner(System.in);
		row1 = input2.nextLine();
		input2 = new Scanner(System.in);
		row2 = input2.nextLine();
		input2 = new Scanner(System.in);
		row3 = input2.nextLine();
		input2 = new Scanner(System.in);
		row4 = input2.nextLine();
		input2 = new Scanner(System.in);
		row5 = input2.nextLine();
		System.out.println("Please enter the first name");
		myObj = new Scanner(System.in);
		name = myObj.nextLine();
		System.out.println("Please enter the account name");
		myObj = new Scanner(System.in);
		account = myObj.nextLine();
		System.out.println("Please enter your location");
		myObj = new Scanner(System.in);
		location = myObj.nextLine();
		System.out.println("Please enter your bio");
		myObj = new Scanner(System.in);
		bio = myObj3.nextLine();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date = new Date(); 
		/**
		INSERT INTO Twitter (FirstName, UserName, Location, Bio, StartDate)
		VALUES ('Brad', 'bradhullinger', 'Denver', 'Ilovetosnowboardandplaythedrumsandprogramcomputers', '01012023');
		**/
		database.executeUpdate("INSERT INTO " + table + " (" + row1 + ", " row2 + ", " + row3 + ", " + row4 + ", " + row5 + ") values (" + name + ", " + account + ", " + location + ", " + bio + ", " + date + ")");

			
		}
		if(ans.equals("Search") == true || ans.equals("search") == true)
		{
			/**
			SELECT * FROM Twitter WHERE FirstName = 'Brad';
			SELECT Location FROM Twitter WHERE FirstName = 'Brad' AND WHERE UserName = 'bradhullinger';
			**/
			System.out.println("SELECT...");
			input2 = new Scanner(System.in);
			firstSQL = input2.nextLine();
			System.out.println("FROM...");
			System.out.println("Please enter table name");
			input1 = new Scanner(System.in);
			table = input1.nextLine();
			System.out.println("WHERE...");
			input2 = new Scanner(System.in);
			secondSQL = input2.nextLine();
			System.out.println("=");
			input2 = new Scanner(System.in);
			answer = input2.nextLine();
	
			ResultSet result;
			result = database.executeQuery("SELECT " + firstSQL + " FROM " + table + " WHERE " + secondSQL + " = " + answer);
			int a = 0;
			while(result.next())
			{
				System.out.println(result.absolute(a));
				a++;
			}
		}
		if(ans.equals("delete") == true || ans.equals("delete table") == true)
		{
			/**
			DROP TABLE Twitter;
			**/
			System.out.println("Please enter the name of the table");
			input1 = new Scanner(System.in);
			table = input1.nextLine();
			database.executeUpdate("DROP TABLE " + table);
		}
	}
}