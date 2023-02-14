package basicProject;

import java.util.List;
import java.util.Scanner;

public class MemberController {
	private static MemberController instance = new MemberController();

	private MemberController() {
	}

	public static MemberController getInstance() {
		return instance;
	}

	private MemberService service = MemberService.getInstance();
	private MemberView view = MemberView.getInstance();

	public int signUpMember(MemberVO vo) {
		return service.signUpMember(vo);
	}
	private ReservationService reservationService = ReservationService.getInstance();
	private ReservationView rView = ReservationView.getInstance();

	public void memberProcess(Scanner scanner) {
		MemberVO vo = view.memberLogin(scanner); // 아이디랑 비밀번호를 갖고있는 객체가있다
		int count = service.login(vo);
		if (count != 1) {
			view.loginFalse();
		}
		view.loginSuccess();
		while (count == 1) {
			int selectNum = view.memberPage(scanner);
			if (selectNum == 1) {

			} else if (selectNum == 2) {
				List<ReservationVO> list = reservationService.searchSchedules();
				rView.printSchedules(list);
				
			} else if (selectNum == 3) {
				view.printMyInfo(service.myInfo(vo.getMemId()));

			} else if (selectNum == 0) {
				break;
			}
		}
	}

}
