package basicProject;

import java.util.Scanner;

public class MemberView {
	private static MemberView instance = new MemberView();
	private MemberView() {
	}
	public static MemberView getInstance() {
		return instance;
	}
	public MemberVO memberLogin(Scanner scanner) {
		System.out.print("아이디 입력>");
		String id = scanner.nextLine();
		System.out.print("비밀번호 입력>");
		String pwd = scanner.nextLine();
		return new MemberVO(id, pwd);
	}
	public int memberPage(Scanner scanner) {
		System.out.print("1.예약하기 | 2.예약 정보 확인 | 3.내 정보 | 0.페이지 나가기");
		return Integer.parseInt(scanner.nextLine());
	}
	public void loginFalse() {
		System.out.println("로그인 실패 ㅠㅠ");
	}
	public void loginSuccess() {
		System.out.println("로그인 성공!!");
	}
	public void printMyInfo(MemberVO vo) {
		System.out.println(vo);
	}
	
	public void printReservationList(ReservationVO vo) {
		System.out.println(vo);
	}
	
}
