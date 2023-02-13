package basicProject;

import java.util.Scanner;

public class FrontController {
	private ReservationController rc = new ReservationController();
	private Scanner scanner = new Scanner(System.in);
	
	public void process() {
		while(true) {
			System.out.println("|  			  Hair Shop 	    	 |");
			System.out.println("------------------------------------");
			System.out.println("1.회원로그인 2.관리자로그인 3.회원가입 0.종료 ");
			System.out.println("------------------------------------");
			System.out.println("메뉴선택: ");
			int selectMenu = Integer.parseInt(scanner.nextLine());
			
			switch(selectMenu) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				String regEx = "(\\d{3})(\\d{4})(\\d{4})";
				
				System.out.print("ID를 입력해주세요> ");
				String newId = scanner.nextLine();
				System.out.print("비밀번호를 입력해주세요> ");
				String newPw = scanner.nextLine();
				System.out.print("비밀번호 확인> ");
				String newPw2 = scanner.nextLine();
				
				boolean success = false;					
				if (newPw.equals(newPw2)) {
					success = true;
				}if(success) {
					System.out.println("비밀번호가 일치합니다.");
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
				System.out.print("이름을 입력해주세요> ");
				String newName = scanner.nextLine();
				System.out.print("생년월일을 입력해주세요(yyyyddmm방식)");
				String newBir = scanner.nextLine();
				System.out.print("전화번호를 입력해주세요> ");
				String newPh = scanner.nextLine().replaceAll(regEx, "$1-$2-$3");
				ReservationController.signUpMember(new MemberVO(newId, newPw, newName, newBir, newPh));
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}

		}
	}
}
