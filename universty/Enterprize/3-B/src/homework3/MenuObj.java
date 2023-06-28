package homework3;

import java.util.Scanner;

public class MenuObj {
	
	public int menuDisplay() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===== Book 관리 프로그램 =====");
		System.out.println("Book 추가 [1]");
		System.out.println("Book 수정 [2]");
		System.out.println("Book 삭제 [3]");
		System.out.println("종료 [4]");
		System.out.println("원하시는 메뉴를 고르시오 : ");
		int selectInt = sc.nextInt();
		return selectInt;
	}
	
	public String commonMessage(String op) {
		Scanner in = new Scanner(System.in);
		System.out.println("===== " + op + "메서드 실행 ======");
		System.out.println(op + "할 기존의 Book 이름 : ");
		return in.nextLine();
	}
}
