package homework3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main3 {
	private BookManager bookMng = null;
	private MenuObj menu = null;

	private void switchOperation(int num) {
		String bookName;
		switch (num) {
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
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:XML/homework/main3.xml");
		Main3 main = (Main3) ctx.getBean("mainObj");
		main.bookMng = (BookManager) ctx.getBean("bookMng");
		main.menu = (MenuObj) ctx.getBean("menu");
		int num;
		while (true) {
			num = main.menu.menuDisplay();
			if (num < 1 || num > 4) {
				System.out.println("기능 번호를 잘못 선택했음!!");
				continue;
			}
			if (num == 4) {
				main.bookMng.bookExit();
				break;
			}
			main.switchOperation(num);
		}
		ctx.close();
	}

}
