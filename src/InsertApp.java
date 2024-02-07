import java.sql.*;
import java.util.Scanner;

public class InsertApp {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;


            //It contains all the appropriate methods to register and deregister the database driver class and to create a connection between a Java application and the database.
            System.out.println("Driver loaded successfully.....");

            //dbprotocolName:dbenginename://ipaddress:portnumber/dbname
            String url = "jdbc:mysql://localhost:3306/newapp";
            String userName = "root";
            String passWord = System.getenv("DATABASE_USER_PASSOWRD");

            //A Connection is a session between a Java application and a database. It helps to establish a connection with the database.
            connection = DriverManager.getConnection(url,userName,passWord);
            System.out.println("Connection established successfully...");
            System.out.println("Classname details " + connection.getClass().getName());

            //Take the inputs from the user
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the name of the player :: ");
            String sname = scanner.next();
            System.out.println("Please enter the age of the player :: ");
            int sage =scanner.nextInt();
            System.out.println("Please enter the team of the player :: ");
            String saddress = scanner.next();

            //SQL query to return ID, name, address and age from the IPLteam table
            String sqlInsertQuery = String.format("Insert into IPLteam(`sname`,`sage`,`saddress`) values ('%s',%d,'%s')",sname, sage,saddress);

            //create statement object which can be used to execute the SQL queries
            statement = connection.createStatement();
            System.out.println("Classname of class implemented : "+ statement.getClass().getName());

            //run the insert query to update the table
            int rowsAffected = statement.executeUpdate(sqlInsertQuery);
            System.out.println("Rows affected :: "+rowsAffected);

            //close the resources
            statement.close();
            connection.close();
            scanner.close();
            System.out.println("Closing the resources!!");

    }
}
