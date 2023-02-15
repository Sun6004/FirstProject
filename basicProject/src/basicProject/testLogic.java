package basicProject;

import java.util.Scanner;

public class testLogic {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String str = scanner.nextLine();
//		if(str==null) {
//			System.out.println("널");
//		}else if (str.equals("")) {
//			System.out.println("공백");
//		}else if (str!=null) {
//			System.out.println("널이 아님");
//		}else {
//			System.out.println("공백이 아님");
//		}
//		String days = "2023";
//		System.out.println("날짜를 입력해주세요");
//		String[] dayArray = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
//				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
//		int selectDay=Integer.parseInt(scanner.nextLine())-1;
//		if(dayArray[selectDay].length()<2) {
//			days += "0";
//		}
//		days+=dayArray[selectDay];
//		System.out.println(days);
		String days = printDays(scanner);
		days += printHour(scanner);
		System.out.println(days);
	}
	private static String printDays(Scanner scanner) {
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
	private static String printHour(Scanner scanner) {
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
		System.out.println("\n");
		System.out.print("시간을 입력해주세요>");
		int selectHour = Integer.parseInt(scanner.nextLine());
		String hour=null;
		switch (selectHour) {
		case 1: hour="1200"; break;
		case 2: hour="1300"; break;
		case 3: hour="1400"; break;
		case 4: hour="1500"; break;
		case 5: hour="1600"; break;
		case 6: hour="1700"; break;
		case 7: hour="1800"; break;
		case 8: hour="1900"; break;
		case 9: hour="2000"; break;
		default: break;
		}
		return hour;
	}
}	
