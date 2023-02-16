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
	      FrontController.nextPage();
	      while (loop) {//로그인이 되면 루프실행
	         try {
	            int selectNum = view.adminMenu(scanner);
	            switch (selectNum) {
	            case 1://디자이너 이름으로 스케줄 확인
	               ReservationVO vo = reservationService.searchSchedule(view.searchDesignerName(scanner));
	               view.printSchedule(vo);
	               break;
	            case 2: // 디자이너 전체 스케줄 확인
	               List<ReservationVO> list = reservationService.searchSchedules();
	               view.printSchedules(list);
	               break;
	            case 3://디자이너 목록 확인
	               List<DesignerVO> list1 = designerService.allDesigner();
	               view.printAllDesigner(list1);
	               break;
	            case 4://디자이너 퇴직처리
	               int count = designerService.deleteDsigner(view.searchDesignerName(scanner));
	               view.deleteSuccesses(count);
	               break;
	            case 5://퇴직자 정보 확인
	               view.retire(designerService.retire());
	               break;
	            case 0:loop = false;FrontController.nextPage();break;
	            default :System.out.println("올바른 번호를 입력해주세요");break;
	            }
	         } catch (Exception e) {System.out.println("다시 입력해주세요.");}
	      }
	   }
}
