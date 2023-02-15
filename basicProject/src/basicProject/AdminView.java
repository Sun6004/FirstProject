package basicProject;

import java.util.List;
import java.util.Scanner;

public class AdminView {
	private static AdminView instance = new AdminView();

	private AdminView() {
	}

	public static AdminView getInstance() {
		return instance;
	}

	public int adminMenu(Scanner scanner) {
	      System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━┓");
	      System.out.println("┃	1. 예약 스케줄 확인		┃2. 전체 스케줄 확인	  ┃    3. 디자이너 정보 조회  ┃   4.디자이너 퇴직처리   ┃   5.퇴직자 조회	┃	0.페이지 나가기  ┃");
	      System.out.println("┗━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━┛");
	      return Integer.parseInt(scanner.nextLine());
	   }
	public String searchDesignerName(Scanner scanner) {
		System.out.print("디자이너 이름을 입력해주세요>");
		return scanner.nextLine();
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
	public void printSchedule(ReservationVO vo) {
		System.out.print("  "+vo.getrDate());
		System.out.print("  "+vo.getMemName());
		System.out.print("  "+vo.getDsiName());
		System.out.print("  "+vo.getMenuName());
		System.out.print("  "+vo.getPrice()+"\n");
	}
	public boolean adminLogin(Scanner scanner) {
		System.out.print("관리자 아이디를 입력하세요>");
	      String adminId = scanner.nextLine();
	      System.out.print("관리자 비밀번호를 입력하세요>");
	      String adminPw = scanner.nextLine();
	      if(adminId.equals("admin")) {
	         if(adminPw.equals("adad123")) {
	            System.out.println("로그인 성공");
	            return true;
	         }else {
	            System.out.println("비밀번호가 틀립니다.");
	         }
	      } else {
	         System.out.println("아이디를 다시 확인해주세요.");
	      }
	      return false;
	}

	public void printAllDesigner(List<DesignerVO> list) {
		for (DesignerVO vo : list) {
			System.out.println(vo);
		}
	}
	public String deleteDsigner(Scanner scanner) {
		System.out.println("삭제할 디자이너 이름을 입력해주세요>");
		return scanner.nextLine();
	}
	public void deleteSuccesses(int count) {
		if(count>0) {
			System.out.println("삭제되었습니다.");
		}else {
			System.out.println("해당 디자이너가 없습니다.");
		}
	}
	public void retire(List<DesignerVO> list) {
		for (DesignerVO  vo: list) {
			System.out.print(vo.getDsiNo());
			System.out.print("  "+vo.getDsiName());
			System.out.println("  "+vo.getDsiBir());
		}
	}
	
}
