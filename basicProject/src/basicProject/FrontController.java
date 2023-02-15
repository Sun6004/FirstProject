package basicProject;

import java.util.Scanner;

public class FrontController {

	private MemberController memberController = MemberController.getInstance();

	private AdminContoller adminContoller = AdminContoller.getInstance();


	private Scanner scanner = new Scanner(System.in);

	public void process() {
		while (true) {
			int selectMenu = mainMenu(scanner);
			switch (selectMenu) {
			case 1:
				memberController.memberProcess(scanner);
				break;
			case 2:
				adminContoller.adminProcess(scanner);
				break;
			case 3:
				memberController.signUpMember(scanner);
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}
	}
	public static int mainMenu(Scanner scanner) {
	       System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
	       System.out.println("┃               ✿✿✿   Ⓗⓐⓘⓡ Ⓢⓗⓞⓟ  ✿✿✿           	    ┃ ");
	       System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ");
	       System.out.println("┏━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━┓");
	       System.out.println("┃ 1.회원 로그인	   ┃  2.관리자 로그인   ┃  3.회원가입  ┃  0.종료   ┃");
	       System.out.println("┗━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━┛");
	      System.out.print("메뉴선택> ");
	      return Integer.parseInt(scanner.nextLine());
	   }

}
