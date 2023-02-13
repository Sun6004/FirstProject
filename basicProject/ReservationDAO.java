package basicProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReservationDAO {
	private static ReservationDAO instance = new ReservationDAO();
	private ReservationDAO() {
		
	}
	public static ReservationDAO getInstance() {
		return instance;
	}
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	

	
	
	private void getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@192.168.146.76:1521:XE"; 
		String user = "HAIRSHOP";
		String password = "java";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url, user, password);
	}
}
