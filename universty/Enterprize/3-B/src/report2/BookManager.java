package report2;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BookManager implements ApplicationContextAware  {
	private List<Book> bookList = null;
	private ApplicationContext context = null;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;
	}

	public BookManager(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	private int search(String searchName) {
		String name;
		for(int i = 0 ; i<bookList.size(); i++) {
			name = bookList.get(i).getBookName();
			if(searchName.equals(name))
				return i;
		}
		return -1;
	}
	
	public List<Book> bookAdd(){
		System.out.println("===== 추가 메서드 실행 =====");
		System.out.println("추가할 book 이름 : ");
		
		String bookName = sc.nextLine();
		if(search(bookName)>=0) {
			System.out.println("책 이름이 중복됨 !! ");
			return bookList;
		}
		Book info = (Book)context.getBean("book");
		info.setBookName(bookName);
		
		this.bookList.add(info);
		return bookList;
	}
	
	public List<Book> bookUpdate(String oldName){
		int pos = search(oldName);
		if(pos < 0) {
			System.out.println("저장된 Book 이름이 없음 !!!");
			return bookList;
		}
		System.out.println("수정할 신규 book 이름 : ");
		String update = sc.nextLine();
		bookList.get(pos).setBookName(update);
		return bookList;
	}
	
	public List<Book> bookDelete(String oldName){
		int pos = search(oldName);
		if(pos < 0) {
			System.out.println("저장된 Book 이름이 없음 !!!");
			return bookList;
		}
		bookList.remove(pos);
		return bookList;
	}
}
