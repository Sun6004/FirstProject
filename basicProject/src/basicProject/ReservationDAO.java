package basicProject;

import java.sql.CallableStatement;
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

	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private CallableStatement cstmt = null;
	private PreparedStatement pstmt = null;

	public List<ReservationVO> searchSchedules() {
		List<ReservationVO> list = new ArrayList<>();
		try {
			dbConnect();
			st = conn.createStatement();
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
			rs = st.executeQuery(sql);

			while (rs.next()) {
				String rNO = rs.getString("rno");
				String rDate = rs.getString("rdate");
				String memName = rs.getString("mem_name");
				String dsiName = rs.getString("dsi_name");
				String menuName = rs.getString("menu_name");
				int price = rs.getInt("price");
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
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String rNO = rs.getString("rno");
				String rDate = rs.getString("rdate");
				String memName = rs.getString("mem_name");
				String dsiName = rs.getString("dsi_name");
				String menuName = rs.getString("menu_name");
				int price = rs.getInt("price");
				vo = new ReservationVO(rNO, rDate, memName, dsiName, menuName, price);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			dbClose();
		}
		return vo;
	}
	public List<ReservationVO> menu1() {
		List<ReservationVO> list = new ArrayList<>();
		try {
			dbConnect();
			st = conn.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT ");
			sb.append("     dsi_no,");
			sb.append("     dsi_name,");
			sb.append("     dsi_posi");
			sb.append(" FROM");
			sb.append("     DESIGNER");
			String sql = sb.toString();
			rs =  st.executeQuery(sql);
			while (rs.next()) {
				String no = rs.getString("dsi_no");
				String name = rs.getString("dsi_name");
				String position = rs.getString("dsi_posi");
				list.add(new ReservationVO(no,name, position));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dbClose();
		}
		return list;
	}

	public List<ReservationVO> menu2() {
		List<ReservationVO> list = new ArrayList<>();
		try {
			dbConnect();
			st = conn.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT");
			sb.append("     menu_no,");
			sb.append("     menu_name,");
			sb.append("     price");
			sb.append(" FROM");
			sb.append("     v_price");
			String sql = sb.toString();
			rs =  st.executeQuery(sql);
			while (rs.next()) {
				String menuNo = rs.getString("menu_no");
				String menuName = rs.getString("menu_name"); 
				int price = rs.getInt("price"); 
				list.add(new ReservationVO(menuName,menuNo,price));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dbClose();
		}
		return list;
	}
	public int duplicateInspection(ReservationVO vo) {
		int count = 0;
		try {
			dbConnect();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT");
			sb.append("     mid");
			sb.append(" FROM");
			sb.append("     v_reservation");
			sb.append(" WHERE");
			sb.append("     rdate =?");
			sb.append("     AND   dsi_no =?");
			String sql = sb.toString();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getrDate().trim());
			pstmt.setString(2, vo.getDsiNo().trim());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			dbClose();	
		}
		return count;
	}
	
	public int reservation(ReservationVO vo) {
		int count = 0;
		try {
			dbConnect();
			cstmt = conn.prepareCall("{call proc_reservation(?,?,?,?)}");			
			cstmt.setString(1,vo.getrDate().trim());
			cstmt.setString(2,vo.getMemId().trim());
			cstmt.setString(3,vo.getDsiNo().trim());
			cstmt.setString(4,vo.getMenuNo().trim());
			count = cstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return count;
	}
	public ReservationVO reservationInfo(String memID) {
	      ReservationVO vo = null;
	      try {
	         dbConnect();
	         StringBuilder builder = new StringBuilder();
	         builder.append("SELECT ");
	         builder.append("    rno, ");
	         builder.append("    rdate, ");
	         builder.append("    mem_name, ");
	         builder.append("    dsi_name, ");
	         builder.append("    menu_name, ");
	         builder.append("    price ");
	         builder.append("FROM ");
	         builder.append("    v_reservation ");
	         builder.append("WHERE ");
	         builder.append("    mid =? ");
	         String sql = builder.toString();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, memID);
	         ResultSet resultSet2 = pstmt.executeQuery();
	         while(resultSet2.next()) {
	            String rNo1 = resultSet2.getString("rno");
	            String rDate = resultSet2.getString("rdate");
	            String memName = resultSet2.getString("mem_name");
	            String dsiName = resultSet2.getString("dsi_name");
	            String menuName = resultSet2.getString("menu_name");
	            int price = resultSet2.getInt("price");
	            vo = new ReservationVO(rNo1, rDate, memName, dsiName, menuName, price);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         dbClose();
	      }
	      return vo;
	   }
	   
	   public int resrvationCancle(String memID){
	      int count = 0;
	      try {
	         dbConnect();
	         StringBuilder builder = new StringBuilder();
	         builder.append("DELETE FROM reservation WHERE ");
	         builder.append("    mem_id = ? ");
	         String sql = builder.toString();
	         PreparedStatement statement2 = conn.prepareStatement(sql);
	         statement2.setString(1, memID);
	         count = statement2.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         dbClose();
	      }
	      
	      return count;
	   }

	private void dbConnect() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@192.168.146.76:1521:XE";
		String user = "HAIRSHOP";
		String password = "java";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, password);
	}

	private void dbClose() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (cstmt != null) {
				cstmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
