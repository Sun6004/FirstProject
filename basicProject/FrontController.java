package basicProject;

import java.util.Scanner;

public class FrontController {
	private ReservationController rc = new ReservationController();
	private Scanner scanner = new Scanner(System.in);
	
	public void process() {
		while(true) {
			System.out.println("|  			  Hair Shop 	    	 |");
			System.out.println("------------------------------------");
			System.out.println("1.회원로그인 2.관리자로그인 3.회원가입 4종료 ");
			System.out.println("------------------------------------");
			System.out.println("메뉴선택: ");
			int selectMenu = Integer.parseInt(scanner.nextLine());
			
			switch(selectMenu) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
			
			
		}
	}
}
