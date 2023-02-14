package basicProject;

import java.util.List;
import java.util.Scanner;

public class ReservationView {
	private static ReservationView instance = new ReservationView();

	private ReservationView() {
	}

	public static ReservationView getInstance() {
		return instance;
	}

	public int mainMenu(Scanner scanner) {
		System.out.println("|  			  Hair Shop 	    	 |");
		System.out.println("------------------------------------");
		System.out.println("1.회원로그인 2.관리자로그인 3.회원가입 0.종료 ");
		System.out.println("------------------------------------");
		System.out.print("메뉴선택: ");
		return Integer.parseInt(scanner.nextLine());
	}
	public void printSchedules(List<ReservationVO> list) {
		for (ReservationVO vo : list) {
			System.out.print(vo.getrNo());
			System.out.print("  "+vo.getrDate());
			System.out.print("  "+vo.getMemName());
			System.out.print("  "+vo.getDsiName());
			System.out.print("  "+vo.getMenuName());
			System.out.print("  "+vo.getPrice()+"\n");
		}

	
	
	
	}

}
