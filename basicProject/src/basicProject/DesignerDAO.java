package basicProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DesignerDAO {
	private static DesignerDAO instance = new DesignerDAO();

	private DesignerDAO() {
	}

	public static DesignerDAO getInstance() {
		return instance;
	}

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	

	public List<DesignerVO> allDesigner() {
		List<DesignerVO> list = new ArrayList<>();
		try {
			dbConnect();
			statement = connection.createStatement();
			StringBuilder builder = new StringBuilder();
			builder.append("  SELECT");
			builder.append("     dsi_no,");
			builder.append("     dsi_name,");
			builder.append("     dsi_bir,");
			builder.append("     dsi_ph,");
			builder.append("     dsi_posi,");
			builder.append("     hire_date");
			builder.append(" FROM");
			builder.append("     designer");
			String sql = builder.toString();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String dsiNo = resultSet.getString("dsi_no");
				String dsiName = resultSet.getString("dsi_name");
				String dsiBir = String.valueOf(dateFormat.format(resultSet.getDate("dsi_bir")));
				String dsiPh = resultSet.getString("dsi_ph");
				String dsiPosition = resultSet.getString("dsi_posi");
				String hireDate = String.valueOf(dateFormat.format(resultSet.getDate("hire_date")));
				list.add(new DesignerVO(dsiNo, dsiName, dsiBir, dsiPh, dsiPosition,hireDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	public int deleteDsigner(String name) {
		int count = 0;
		try {
			dbConnect();
			StringBuilder sb = new StringBuilder();
			sb.append(" DELETE FROM designer WHERE");
			sb.append("     dsi_name =?");
			String sql = sb.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return count;
	}

	public List<DesignerVO> retire() {
		List<DesignerVO> list = new ArrayList<>();
		try {
			dbConnect();
			statement = connection.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT");
			sb.append("     dsi_no,");
			sb.append("     dsi_name,");
			sb.append("     dsi_posi");
			sb.append(" FROM");
			sb.append("     retire");
			String sql = sb.toString();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				String dsiNo = resultSet.getString("dsi_no");
				String dsiName = resultSet.getString("dsi_name");
				String dsiPosi = resultSet.getString("dsi_posi");
				list.add(new DesignerVO(dsiNo, dsiName, dsiPosi));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dbClose();
		}
		return list;
	}

	private void dbConnect() throws ClassNotFoundException, SQLException {
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