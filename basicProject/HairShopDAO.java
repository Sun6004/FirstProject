package basicProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class HairShopDAO {
	public static void main(String[] args) {
		new OracleDriver();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.146.76:1521:xe";
			String user = "HAIRSHOP";
			String pw = "java";
			
			connection = DriverManager.getConnection(url,user,pw);
			statement = connection.createStatement();
			
			StringBuilder builder = new StringBuilder();
			builder.append(" ");
			builder.append(" ");
			builder.append(" ");
			builder.append(" ");
			builder.append(" ");
			builder.append(" ");
		
	
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) {
				resultSet.close();
				}
			} catch (SQLException e2) {
			}
			try {
				if(statement != null) {
				statement.close();
				}
			} catch (SQLException e1) {
			}
			try {if(connection != null) {
				connection.close();
			}
			} catch (SQLException e) {
			}
		}
	}
}
