package basicProject;

import java.util.Scanner;

public class ReservationView {
	private static ReservationView instance = new ReservationView();

	   private ReservationView() {
	   }

	   public static ReservationView getInstance() {
	      return instance;
	   }

	   public int mainMenu(Scanner scanner) {
	      System.out.println("|             Hair Shop            |");
	      System.out.println("------------------------------------");
	      System.out.println("1.회원로그인 2.관리자로그인 3.회원가입 0.종료 ");
	      System.out.println("------------------------------------");
	      System.out.print("메뉴선택: ");
	      return Integer.parseInt(scanner.nextLine());
	   }

	   public MemberVO memberLogin(Scanner scanner) {
	      System.out.print("아이디를 입력하세요>");
	      String id =scanner.nextLine();
	      System.out.print("비밀번호를 입력하세요>");
	      String pw = scanner.nextLine();
	      return new MemberVO(id, pw);
	   }

	   public int reservationText(Scanner scanner) {
	      System.out.println("1.예약하기 | 2.예약 정보확인 | 3.내정보 ");
	      return Integer.parseInt(scanner.nextLine());
	   }

	}
