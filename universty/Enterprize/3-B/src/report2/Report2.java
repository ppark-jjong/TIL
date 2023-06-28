package report2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Report2 {

	private BookManager bookMng= null;
	private MenuObj menu = null;
	
	private void switchOperation(int num) {
		String bookName;
		switch(num) {
		case 1:
			bookMng.bookAdd();
			break;
		case 2:
			bookName = menu.commonMessage("수정");
			bookMng.bookUpdate(bookName);
			break;
		case 3:
			bookName = menu.commonMessage("삭제");
			bookMng.bookDelete(bookName);
			break;
		}
	}
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:report2/main.xml");
		Report2 main = (Report2)context.getBean("mainObj");
		main.bookMng = (BookManager) context.getBean("bookMng");
		main.menu = (MenuObj) context.getBean("menu");
		
		int num;
		while(true) {
			num = main.menu.menuDisplay();
			if(num < 1 || num>4) {
				System.out.println("기능 번호를 잘못 선택하였음 !");
				continue;
			}
			if(num ==4) {
				System.out.println("프로그램을 종료 합니다");
				break;
			}
			main.switchOperation(num);
		}
		context.close();
	}

}
