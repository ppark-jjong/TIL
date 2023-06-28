package etc;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("file:XML/etc/report2.xml");
		
		BookManager b = (BookManager)context.getBean("bookManager");
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("도서 관리 기능입니다. 원하는 기능을 선택하십시오.");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서명 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 종료");
			int selectedNum = s.nextInt();
			if (selectedNum == 4) {
				context.close();
				return;
			}
			
			switch(selectedNum) {
			case 1 : b.addBook();
			break;
			case 2 : b.changeBook();
			break;
			case 3 : b.deleteBook();
			break;
			}
		}
	}

}
