package homework2;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("file:XML/homework/main2.xml");
		BookManager m = (BookManager) context.getBean("BookManag");
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("책 관리 시스템입니다.");
			System.out.println("1. 책 추가 \n2. 책 수정 \n3. 책 삭제 \n4. 종료");
			System.out.print("원하시는 기능을 선택하시오 : ");
			int num = sc.nextInt();
			if (num == 1) {
				System.out.println("책 추가를 선택하였습니다.");
				System.out.println("=====================");
				m.addBook();
			} else if (num == 2) {
				System.out.println("책 수정을 선택하였습니다.");
				System.out.println("=====================");
				m.renameBook();
			} else if (num == 3) {
				System.out.println("책 삭제를 선택하였습니다.");
				System.out.println("=====================");
				m.deleteBook();
			} else if (num == 4) {
				System.out.println("종료");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}

			context.close();

		}

	}
}
