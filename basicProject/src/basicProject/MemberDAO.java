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
	private PreparedStatement pstmt =null;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public List<MemberVO> searchMembers(String selectId) {
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
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, selectId);
				resultSet = pstmt.executeQuery();
			} else {
				statement = connection.createStatement();
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
			while (resultSet.next()) {
				String memId = resultSet.getString("mem_id");
				String memPw = resultSet.getString("mem_pw");
				String memName = resultSet.getString("mem_name");
				Date memBir = resultSet.getDate("mem_bir");
				String memPh = resultSet.getString("mem_ph");
				list.add(new MemberVO(memId, memPw, memName, dateFormat.format(memBir), memPh));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
			if (pstmt != null) {
				pstmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int signUpMember(MemberVO vo) {
		int count = 0;
		try {
			getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" INSERT INTO member (");
			sb.append("         mem_id,");
			sb.append("         mem_pw,");
			sb.append("         mem_name,");
			sb.append("         mem_bir,");
			sb.append("         mem_ph");
			sb.append("     ) VALUES (");
			sb.append("         ?,");
			sb.append("         ?,");
			sb.append("         ?,");
			sb.append("         ?,");
			sb.append("         ?");
			sb.append("     )");
			String sql = sb.toString();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getMemId());
			pstmt.setString(2, vo.getMemPw());
			pstmt.setString(3, vo.getMemName());
			pstmt.setString(4, vo.getMemBir());
			pstmt.setString(5, vo.getMemPh());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dbClose();
		}
		return count;
	}

	public int login(MemberVO vo) {
		int count = 0;
		try {
			getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT");
			sb.append("     mem_id,");
			sb.append("     mem_pw,");
			sb.append("     mem_name,");
			sb.append("     TO_CHAR(mem_bir,'yyyy/dd/mm'),");
			sb.append("     mem_ph");
			sb.append(" FROM");
			sb.append("     member");
			sb.append(" WHERE");
			sb.append("     mem_id =?");
			sb.append("     AND   mem_pw =?");
			String sql = sb.toString();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getMemId());
			pstmt.setString(2, vo.getMemPw());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return count;
	}

	public int checkId(String id) {
		int value = 0;

		try {
			String sql = "SELECT mem_id FROM member WHERE mem_id = ?";
			getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			value = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return value;
	}

	public MemberVO myInfo(String memId) {
		MemberVO vo = null;
		try {
			getConnection();
			StringBuilder sb = new StringBuilder();
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
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, memId);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("mem_id");
				String memPw = resultSet.getString("mem_pw");
				String memName = resultSet.getString("mem_name");
				Date memBir = resultSet.getDate("mem_bir");
				String memPh = resultSet.getString("mem_ph");
				vo = new MemberVO(memId, memPw, memName, dateFormat.format(memBir), memPh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}

	public int deleteMyInfo(String memId) {
		int count = 0;
		try {
			getConnection();
			StringBuilder builder = new StringBuilder();
			builder.append("DELETE FROM member WHERE ");
			builder.append("    mem_id =? ");
			String sql = builder.toString();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, memId);
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return count;
	}

	public int updateMyInfo(MemberVO vo) {
		int count = 0;
		try {
			getConnection();
			StringBuilder builder = new StringBuilder();
			builder.append("UPDATE member ");
			builder.append("    SET ");
			builder.append("        mem_pw =?, ");
			builder.append("        mem_ph =? ");
			builder.append("WHERE ");
			builder.append("    mem_id =? ");
			String sql = builder.toString();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getMemPw());
			pstmt.setString(2, vo.getMemPh());
			pstmt.setString(3, vo.getMemId());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return count;
	}
}
