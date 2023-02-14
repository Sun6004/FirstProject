package basicProject;

import java.util.Scanner;

public class testLogic {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		if(str==null) {
			System.out.println("널");
		}else if (str.equals("")) {
			System.out.println("공백");
		}else if (str!=null) {
			System.out.println("널이 아님");
		}else {
			System.out.println("공백이 아님");
		}
	}
}	
