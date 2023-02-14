package basicProject;

import java.util.Scanner;

public class FrontController {
	
	private MemberController memberController = MemberController.getInstance();
	
	private AdminContoller adminContoller = AdminContoller.getInstance();
	
	private ReservationView view = ReservationView.getInstance();
	
	private Scanner scanner = new Scanner(System.in);

	public void process() {
		while (true) {
			int selectMenu = view.mainMenu(scanner);
			switch (selectMenu) {
			case 1:
				memberController.memberProcess(scanner);
//				MemberVO vo = view.memberLogin(scanner);
//				if (memberController.login(vo) > 0) {
//					System.out.println("로그인 성공");
//					int selectFirst = view.reservationText(scanner);
//					switch (selectFirst) {
//					case 1:
//						selectDays();
////						selectHour();
//
//						break;
//					case 2:
////						adminContoller.adminProcess(scanner);
//						break;
//					case 3:
//						break;
//					}
//				} else {
//					System.out.println("로그인 실패");
//				}
				break;
			case 2:
				adminContoller.adminProcess(scanner);
				break;
			case 3:
				String regEx = "(\\d{3})(\\d{4})(\\d{4})";

				System.out.print("ID를 입력해주세요> ");
				String newId = scanner.nextLine();
				System.out.print("비밀번호를 입력해주세요> ");
				String newPw = scanner.nextLine();
				System.out.print("비밀번호 확인> ");
				if (newPw.equals(scanner.nextLine())) {
					System.out.println("비밀번호가 일치합니다.");
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
					break;
				}
				System.out.print("이름을 입력해주세요> ");
				String newName = scanner.nextLine();
				System.out.print("생년월일을 입력해주세요(yyyyddmm방식)");
				String newBir = scanner.nextLine();
				System.out.print("전화번호를 입력해주세요> ");
				String newPh = scanner.nextLine().replaceAll(regEx, "$1-$2-$3");
				if (memberController.signUpMember(new MemberVO(newId, newPw, newName, newBir, newPh)) > 0) {
					System.out.println("회원가입 성공!");
				} else {
					System.out.println("회원가입 실패");
				}
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}

	public void selectHour() {
		System.out.println("---------------------------------------------------");
		System.out.println("                     시간 선택");
		System.out.println("---------------------------------------------------");
		String[] timeList = { "(1) 12:00", "(2) 13:00", "(3) 14:00", "(4) 15:00", "(5) 16:00", "(6) 17:00", "(7) 18:00",
				"(8) 19:00", "(9) 20:00" };

		for (int i = 0; i < timeList.length; i++) {
			if (i >= 0 && i < 3) {
				System.out.printf("    %s   ", timeList[i]);
				if (i == 2) {
					System.out.println();
				}
			} else if (i >= 3 && i < 6) {
				System.out.printf("    %s   ", timeList[i]);
				if (i == 5) {
					System.out.println();
				}
			} else {
				System.out.printf("    %s   ", timeList[i]);
			}

		}
	}
	public void selectDays() {
		String[] dayArray = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		System.out.println("--------------------- ");
		System.out.println("        MARCH       ");
		System.out.println("---------------------");
		System.out.println("일 월 화 수 목 금 토 ");
		for (int i = 0; i < dayArray.length; i++) {
			if (i >= 0 && i < 4) {
				if (i == 0) {
					System.out.printf("          %s ", dayArray[i]);
				} else if (i < 3) {
					System.out.printf(" %s ", dayArray[i]);
				}
				if (i == 3) {
					System.out.printf(" %s", dayArray[i]);
					System.out.println();
				}
			} else if (i >= 4 && i < 11) {
				if (i < 9) {
					System.out.printf(" %s ", dayArray[i]);
				} else if (i == 9) {
					System.out.printf("%s ", dayArray[i]);
				} else {
					System.out.printf("%s", dayArray[i]);
					System.out.println();
				}
			} else if (i >= 12 && i < 18) {
				System.out.printf("%s ", dayArray[i]);
				if (i == 17) {
					System.out.println();
				}
			} else if (i >= 18 && i < 25) {
				System.out.printf("%s ", dayArray[i]);
				if (i == 24) {
					System.out.println();
				}
			} else {
				System.out.printf("%s ", dayArray[i]);
			}
		}
	}
}
	

