package report2;

import java.util.Scanner;

public class MenuObj {
	public int menuDisplay() {
		Scanner in = new Scanner(System.in);

		System.out.println("===== Book 관리 프로그램 =====");
		System.out.println("Book 추가 [1]");
		System.out.println("Book 수정 [2]");
		System.out.println("Book 삭제 [3]");
		System.out.println("프로그램 종료 [4]");
		System.out.println("기능 선택 : ");

		return in.nextInt();
	}

	public String commonMessage(String op) {
		Scanner in = new Scanner(System.in);
		System.out.println("=====" + op + "메서드 실행 =====");
		System.out.println(op + "할 기존 book 이름 : ");
		return in.nextLine();
	}

}
