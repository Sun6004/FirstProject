package basicProject;

import java.util.List;
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
		System.out.println("┏━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃ 1.예약하기   ┃   2.예약 정보 확인  ┃ 3.내 정보   ┃ 0.페이지 나가기   ┃");
		System.out.println("┗━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━┛");
		return Integer.parseInt(scanner.nextLine());
	}

	public void loginFalse() {
		System.out.println(" 로그인 실패😥");
	}

	public void loginSuccess() {
		System.out.println(" 로그인 성공!😄");
	}

	public void printMyInfo(MemberVO vo) {
		System.out.println(vo);
	}

	

	public String reservationTime(Scanner scanner) {
		String days = printDays(scanner);
		return days += printHour(scanner);
	}

	public String printMenu1(List<ReservationVO> list, Scanner scanner) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print("(" + (i+1) + ")");
			System.out.printf(" %s\t%s\t\n", list.get(i).getDsiName(), list.get(i).getPosition());
		}
		System.out.print("원하시는 디자이너를 번호로 선택해주세요 >");
		int selectNum = Integer.parseInt(scanner.nextLine())-1;
		return list.get(selectNum).getDsiNo();
	}
	public String printMenu2(List<ReservationVO> list, Scanner scanner) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print("(" + (i+1) + ")");
			System.out.printf(" %s\t%s\t\n", list.get(i).getMenuName(), list.get(i).getPrice());
		}
		System.out.print("원하시는 시술을 번호로 선택해주세요 >");
		int selectNum = Integer.parseInt(scanner.nextLine())-1;
		return list.get(selectNum).getMenuNo();
	}

	private String printDays(Scanner scanner) {
		String[] dayArray = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┓ ");
        System.out.println("┃         M͓̽A͓̽R͓̽C͓̽H͓̽  	  ┃");
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("┃  일 월 화 수 목 금 토  ┃");
           for(int i = 0; i < dayArray.length; i++) {   
               if (i>=0 && i<4) {
                  if (i==0) {
                     System.out.printf("┃          %s ",dayArray[i]);
                  } else if (i<3) {
                     System.out.printf(" %s ",dayArray[i]);
                  }
                  if (i==3) {
                     System.out.printf(" %s ┃",dayArray[i]);
                     System.out.println();
                  }
               } else if (i>=4 && i<11) {           
                  if(i==4) {
                    System.out.printf("┃ %s ",dayArray[i]); 
                 }else if (i<9) {
                     System.out.printf(" %s ",dayArray[i]);
                  } else if (i==9){
                     System.out.printf("%s ",dayArray[i]);
                  } else {
                     System.out.printf("%s ┃",dayArray[i]);
                     System.out.println();
                  }
               } else if (i>=11 && i<18) {   
                  if(i==11) {
                     System.out.printf("┃%s ",dayArray[i]);
                  } else if (i==17) {
                     System.out.printf("%s ┃",dayArray[i]);
                      System.out.println();
                  } else {
                     System.out.printf("%s ",dayArray[i]);
                  }
               } else if (i>=18 && i<25){           
                  if (i==18) {
                     System.out.printf("┃%s ",dayArray[i]);
                  } else if(i==24) {
                     System.out.printf("%s ┃",dayArray[i]);
                     System.out.println();
                  } else {
                     System.out.printf("%s ",dayArray[i]);
                  }     
              }  else {   
                 if(i==25) {
                   System.out.printf("┃%s ",dayArray[i]); 
                 } else if (i==30){
                   System.out.printf("%s    ┃",dayArray[i]);    
                 } else {
                    System.out.printf("%s ",dayArray[i]);    
                 }
              }     
              }
              System.out.println("\n┗━━━━━━━━━━━━━━━━━━━━━┛");    

		System.out.println("\n");
		System.out.print("날짜를 선택해주세요>");
		String days = "202303";
		int selectDay = Integer.parseInt(scanner.nextLine()) - 1;
		if (dayArray[selectDay].length() < 2) {
			days += "0";
		}
		days += dayArray[selectDay];
		return days;
	}

	private String printHour(Scanner scanner) {
		  System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
	      System.out.println("┃                      시간 선택                        ┃");
	      System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	      String[] timeList = { "❶ 12:00", "❷ 13:00", "❸ 14:00", "❹ 15:00", "❺ 16:00", "❻ 17:00", "❼ 18:00",
	            "❽ 19:00", "❾ 20:00" };

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
		System.out.println("\n");
		System.out.print("시간을 입력해주세요>");
		int selectHour = Integer.parseInt(scanner.nextLine());
		String hour = null;
		switch (selectHour) {
		case 1:hour = "1200";break;
		case 2:hour = "1300";break;
		case 3:hour = "1400";break;
		case 4:hour = "1500";break;
		case 5:hour = "1600";break;
		case 6:hour = "1700";break;
		case 7:hour = "1800";break;
		case 8:hour = "1900";break;
		case 9:hour = "2000";break;
		default:break;
		}
		return hour;
	}

	public void result(int result) {
		if(result ==1) {
			System.out.println("예약이 완료되었습니다!!");
		}else if (result == 2) {
			System.out.println("예약이 되어있는 시간입니다. 다른시간을 선택해주세요.");
		}
		else {
			System.out.println("예약을 실패했습니다.");
		}
	}
	
	public String printReservation(ReservationVO reservationVO,Scanner scanner) {
		System.out.println("1111111");
	      System.out.println(reservationVO);
	      System.out.print("취소하시겠습니까?(y/n)>");
	      return scanner.nextLine();
	   }
	   
	   public void deleteSuccess(int count) {
		  if(count>0) {
	      System.out.println("예약이 정상적으로 취소되었습니다!!.");
		  }
	   }
	   
	   public void noInfomation() {
	      System.out.println("예약된 정보가 없습니다.");
	   }
	   public String createId(Scanner scanner) {
		      System.out.print("ID를 입력해주세요> ");
		      return scanner.nextLine();
		   }

		   public boolean checkId(int checkId) {
		      if(checkId >0) {
		         System.out.println("사용 불가능한 ID입니다. ");
		         System.out.println("ID를 다시 입력해주세요. ");
		         return true;
		      }
		      System.out.println("사용 가능한 ID입니다. ");
		      return false;
		   }
		   
		   public MemberVO createMember(Scanner scanner,String id) {
		      System.out.print("비밀번호를 입력해주세요> ");
		      String newPw = scanner.nextLine();
		      System.out.print("비밀번호 확인> ");
		      if (!(newPw.equals(scanner.nextLine()))) {
		         System.out.println("비밀번호가 일치하지 않습니다.");
		         System.out.println("비밀번호를 다시 입력해주세요. ");
		         return null;
		      }
		      System.out.println("비밀번호가 일치합니다.");
		      System.out.print("이름을 입력해주세요> ");
		      String newName = scanner.nextLine();
		      System.out.print("생년월일을 입력해주세요(yyyyddmm방식)");
		      String newBir = scanner.nextLine();
		      String regEx = "(\\d{3})(\\d{4})(\\d{4})";
		      System.out.print("전화번호를 입력해주세요> ");
		      String newPh = scanner.nextLine().replaceAll(regEx, "$1-$2-$3");
		      return new MemberVO(id,newPw, newName, newBir, newPh);
		   }
	
}
