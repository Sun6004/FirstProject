package basicProject;

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
	private ReservationService reservationService = ReservationService.getInstance();


	public void memberProcess(Scanner scanner) {
		MemberVO vo = view.memberLogin(scanner); // 아이디랑 비밀번호를 갖고있는 객체가있다
		int count = service.login(vo);
		if (count != 1) {
			view.loginFalse();
		} else {
			view.loginSuccess();
		}
		while (count == 1) {
			int selectNum = view.memberPage(scanner);
			if (selectNum == 1) {
				String dsiNo = view.printMenu1(reservationService.menu1(), scanner);
				String menuNO = view.printMenu2(reservationService.menu2(), scanner);
				String Time = view.reservationTime(scanner);
				int result = reservationService.reservation(new ReservationVO(Time, vo.getMemId(), dsiNo, menuNO));
				view.result(result);
			} else if (selectNum == 2) {
				ReservationVO rvo = reservationService.reservationInfo(vo.getMemId());
				if (rvo == null) {
					view.noInfomation();
				} else {
					String yesOrNo = view.printReservation(rvo, scanner);
					if (yesOrNo.equals("y") || yesOrNo.equals("Y")) {
						view.deleteSuccess(reservationService.reservationDelete(vo.getMemId()));
					}
				}
			} else if (selectNum == 3) {
				view.printMyInfo(service.myInfo(vo.getMemId()));
			} else if (selectNum == 0) {
				break;
			}
		}
	}
	
	public void signUpMember(Scanner scanner) {
		while (true) {
			String newId = view.createId(scanner);
			int checkId = service.checkId(newId);
			if (view.checkId(checkId)) {
				continue;
			}
			MemberVO vo = view.createMember(scanner,newId);
			if (service.signUpMember(vo)==1) {
				System.out.println("회원가입 성공!");
				break;
			}
		}
	}
}
