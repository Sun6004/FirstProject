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

import oracle.jdbc.driver.DBConversion;

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
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public List<ReservationVO> searchSchedules() {
		List<ReservationVO> list = new ArrayList<>();
		try {
			dbConnect();
			statement = connection.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT");
			sb.append("     rno,");
			sb.append("     rdate,");
			sb.append("     mem_name,");
			sb.append("     dsi_name,");
			sb.append("     menu_name,");
			sb.append("     price");
			sb.append(" FROM");
			sb.append("     v_reservation");
			String sql = sb.toString();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String rNO = resultSet.getString("rno");
				String rDate = resultSet.getString("rdate");
				String memName = resultSet.getString("mem_name");
				String dsiName = resultSet.getString("dsi_name");
				String menuName = resultSet.getString("menu_name");
				int price = resultSet.getInt("price");
				list.add(new ReservationVO(rNO, rDate, memName, dsiName, menuName, price));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	public ReservationVO searchSchedule(String name) {
		ReservationVO vo = null;
		try {
			dbConnect();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT");
			sb.append("     rno,");
			sb.append("     rdate,");
			sb.append("     mem_name,");
			sb.append("     dsi_name,");
			sb.append("     menu_name,");
			sb.append("     price");
			sb.append(" FROM");
			sb.append("     v_reservation");
			sb.append(" WHERE");
			sb.append("     dsi_name =?");
			String sql = sb.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, name);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				String rNO = resultSet.getString("rno");
				String rDate = resultSet.getString("rdate");
				String memName = resultSet.getString("mem_name");
				String dsiName = resultSet.getString("dsi_name");
				String menuName = resultSet.getString("menu_name");
				int price = resultSet.getInt("price");
				vo = new ReservationVO(rNO, rDate, memName, dsiName, menuName, price);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dbClose();
		}
		return vo;
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
