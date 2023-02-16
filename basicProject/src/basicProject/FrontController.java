package basicProject;

import java.util.Scanner;

public class FrontController {

	private MemberController memberController = MemberController.getInstance();

	private AdminContoller adminContoller = AdminContoller.getInstance();

	private Scanner scanner = new Scanner(System.in);

	public void process() {
		while (true) {
			try {
				int selectMenu = mainMenu(scanner);
				switch (selectMenu) {
				case 1://회원 로그인
					memberController.memberProcess(scanner);
					break;
				case 2://관리자 로그인
					adminContoller.adminProcess(scanner);
					break;
				case 3://회원 가입
					memberController.signUpMember(scanner);
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					break;
				}
			} catch (Exception e) {
				System.out.println("다시 입력해주세요...");
			}
		}
	}

	public static int mainMenu(Scanner scanner) {
		System.out.println("╔═════════════════════════ °• ♔ •° ══════════════════════╗ ");
		System.out.println("┃               ✿✿✿   Ⓗⓐⓘⓡ Ⓢⓗⓞⓟ  ✿✿✿             ┃ ");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛  ");
		System.out.println("┏━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━┓");
		System.out.println("┃ 1.회원로그인  ┃ 2.관리자로그인 ┃ 3.회원가입 ┃  0.종료  ┃");
		System.out.println("┗━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━┛");
		System.out.print("Input。─➤");
		return Integer.parseInt(scanner.nextLine());
	}
	
	public static void nextPage() {
		long start = 0;
		System.out.print("Please Wait.. ");
		while (true) {
			start++;
			if (start == 311100000)
				System.out.print("▁▂▃");
			if (start == 530050000)
				System.out.print("▄▅");
			if (start == 666050000)
				System.out.print("▆▇");
			if (start == 1130050000) {
				System.out.print("█▉");
				break;
			}
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
				+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}
