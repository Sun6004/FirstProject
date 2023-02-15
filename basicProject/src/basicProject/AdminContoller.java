package basicProject;

import java.util.List;
import java.util.Scanner;

public class AdminContoller {
	private static AdminContoller instance = new AdminContoller();
	private AdminContoller() {
	}
	public static AdminContoller getInstance() {
		return instance;
	}
	
	private AdminView view = AdminView.getInstance();
	private ReservationService reservationService = ReservationService.getInstance();
	private DesignerService designerService = DesignerService.getInstance();
	public void adminProcess(Scanner scanner) {
		boolean loop = view.adminLogin(scanner);
		while(loop) {
			int selectNum = view.adminMenu(scanner);
			if (selectNum == 1) {
				String name = view.searchDesignerName(scanner);
				ReservationVO vo = reservationService.searchSchedule(name);
				view.printSchedule(vo);
			} else if (selectNum == 2) {
				List<ReservationVO> list = reservationService.searchSchedules();
				view.printSchedules(list);
			} else if (selectNum == 3) {
				List<DesignerVO> list = designerService.allDesigner();
				view.printAllDesigner(list);
			} else if (selectNum == 4) {
				int count = designerService.deleteDsigner(view.deleteDsigner(scanner));
				view.deleteSuccesses(count);
			}else if (selectNum == 5) {
				view.retire(designerService.retire());
			}else if (selectNum == 0) {
				break;
			}
		}
	}
}
