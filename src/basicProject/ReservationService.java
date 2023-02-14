package basicProject;

import java.util.List;

public class ReservationService {
	private static ReservationService instance = new ReservationService();
	private ReservationService() {
	}
	public static ReservationService getInstance() {
		return instance;
	}
	private ReservationDAO dao = ReservationDAO.getInstance();
	public ReservationVO searchSchedule(String name) {
		return dao.searchSchedule(name);
	}
	
	public List<ReservationVO> searchSchedules() {
		return dao.searchSchedules();
	}
	
	
}
