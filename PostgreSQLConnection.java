package UserManage;

import java.sql.Connection; //for Connection of java(spring boot) to PostgreSQL.
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgreSQLConnection {
	private static final String URL= "jdbc:postgresql://localhost:5432/USER_MANAGEMNT_DATABASE";
	private static final String USER="postgres";
	private static final String PASSWORD="PostgreSQL";
	
public static Connection dbconnect(){
		
		try {
			return DriverManager.getConnection(URL,USER,PASSWORD);
		}catch (SQLException e){
			System.out.println("The Database Connection Failed !");
			e.printStackTrace();
			return null;
		}
	}
}
