package homework3;

import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BookManager implements ApplicationContextAware  {
	private ApplicationContext context = null;
	private BookDao bookDao = null;
	Scanner sc = new Scanner(System.in);
	
	public BookManager(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public void bookAdd() {
		System.out.println("=====추가 메서드 실행 =====");
		System.out.println("추가할 Book 이름 : ");
		
		String bookName = sc.nextLine();
		int cnt = bookDao.search(bookName);
		System.out.println(cnt);
		if(cnt > 0 ) {
			System.out.println("중복되는 책이름이 있습니다");
			return;
		}
		Book info = (Book)context.getBean("book");
		info.setName(bookName);
		bookDao.insert(info);
		System.out.println(bookName + "이 정상적으로 추가 되었습니다.");
	}
	
	public void bookUpdate(String oldName) {
		int cnt = bookDao.search(oldName);
		//BookDao에서 search 함수의 리턴은 일치하는 name의 index 값이므로 1보다 적으면 일치하는 값이 없다
		if(cnt < 1) {
			System.out.println(oldName + "과 일치하는 책이 없습니다");
			return;
		}
		System.out.println("수정할 책 이름을 적으시오 : ");
		String newName = sc.nextLine();
		bookDao.update(newName, oldName);	
	}
	
	public void bookDelete(String oldName) {
		int cnt = bookDao.search(oldName);
		if(cnt < 1) {
			System.out.println(oldName + "과 일치하는 책이 없습니다");
			return;
		}
		bookDao.delete(oldName);	
	}
	
	public void bookExit() {
		System.out.println("프로그램을 종료합니다.");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		this.context = arg0;
	}
	
	
	
	
}