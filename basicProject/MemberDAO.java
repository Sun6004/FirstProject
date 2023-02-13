package basicProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {
	}
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public List<MemberVO> selectMembers(String selectId) {
		List<MemberVO> list = new ArrayList<>();
		try {
			getConnection();
			StringBuilder sb = new StringBuilder();
			if (!(selectId.equals(""))) {
				sb.append(" SELECT");
				sb.append("     mem_id,");
				sb.append("     mem_pw,");
				sb.append("     mem_name,");
				sb.append("     mem_bir,");
				sb.append("     mem_ph");
				sb.append(" FROM");
				sb.append("     member");
				sb.append(" WHERE");
				sb.append("     mem_id =?");
				String sql = sb.toString();

				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, selectId);
				resultSet = pstmt.executeQuery();
			}else {
				statement= connection.createStatement();
				sb.append(" SELECT");
				sb.append("     mem_id,");
				sb.append("     mem_pw,");
				sb.append("     mem_name,");
				sb.append("     mem_bir,");
				sb.append("     mem_ph");
				sb.append(" FROM");
				sb.append("     member");
				String sql = sb.toString();
				resultSet = statement.executeQuery(sql);
			}
			while(resultSet.next()) {
				String memId =resultSet.getString("mem_id");
				String memPw =resultSet.getString("mem_pw");
				String memName =resultSet.getString("mem_name");
				Date memBir =resultSet.getDate("mem_bir");
				String memPh =resultSet.getString("mem_ph");
				list.add(new MemberVO(memId, memPw, memName, dateFormat.format(memBir), memPh));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	
	
	private void getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@192.168.146.76:1521:XE"; 
		String user = "HAIRSHOP";
		String password = "java";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url, user, password);
	}

	private void dbClose() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

