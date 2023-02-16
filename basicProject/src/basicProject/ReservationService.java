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
	public List<ReservationVO> menu1() {
		return dao.menu1();
	}
	public List<ReservationVO> menu2(String designerName) {
		return dao.menu2(designerName);
	}
	public int reservation(ReservationVO vo) {
		if(dao.duplicateInspection(vo)>0) {
			return 2;
		}
		return dao.reservation(vo);
	}
	
	public List<ReservationVO> reservationInfo(String memID) {
		return dao.reservationInfo(memID);
	}

	public int reservationDelete(List<ReservationVO> list,int num) {
		if(num<0) {
			return num;
		}
		else {
		return dao.resrvationCancle(list.get(num).getrNo());
		}
	}
	
	
}
