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
	private ReservationService reservationService = ReservationService.getInstance();

	public void memberProcess(Scanner scanner) { //회원 컨트롤러
		MemberVO vo = view.memberLogin(scanner); // 아이디랑 비밀번호를 갖고있는 객체가있다
		int count = service.login(vo);
		boolean login = count == 1;
		view.login(login);
		while (login) { //로그인이 완료되면 루프가 실행!
			try {
				int selectNum = view.memberPage(scanner);
				switch (selectNum) {
				case 1:	//예약하기
					ReservationVO drvo = view.designerName(reservationService.menu1(),scanner);
					ReservationVO rvo = view.reservationConditions(drvo.getDsiNo(),
							reservationService.menu2(drvo.getDsiName()), scanner, vo.getMemId());
					int result = reservationService.reservation(rvo);
					view.result(result);
					break;
				case 2: //예약 정보확인
					List<ReservationVO> list = reservationService.reservationInfo(vo.getMemId());
					int num = view.printReservation(list, scanner);
					view.deleteSuccess(reservationService.reservationDelete(list, num));
					break;
				case 3: // 내정보 
					view.printMyInfo(service.myInfo(vo.getMemId()));
					int myInfoMenuNum = view.myInfoMenu(scanner);
					switch (myInfoMenuNum) {
					case 1://내정보 수정
						int updateMyInfo = service.updateMyInfo(view.updateMyInfo(scanner, vo.getMemId()));
						view.updateSuccess(updateMyInfo);
						break;
					case 2://회원탈퇴
						String yesOrNo = view.withDrawal(scanner);
						int fulfill = service.deleteMyInfo(vo.getMemId(), yesOrNo);
						login = view.withDrawalSucess(fulfill);
						break;
					default:view.errMessage();break;
					}
					break;
				case 0:FrontController.nextPage();login = false;break;
				default:view.errMessage();break;
				}
			} catch (Exception e) {
				view.errMessage();
			}
		}
	}

	public void signUpMember(Scanner scanner) {//회원가입
		while (true) {
			String newId = view.createId(scanner);
			int checkId = service.checkId(newId);
			if (view.checkId(checkId)) {continue;}
			MemberVO vo = view.createMember(scanner, newId);
			if (service.signUpMember(vo) == 1) {
				System.out.println("회원가입 성공!");
				break;
			}
		}
	}
}
