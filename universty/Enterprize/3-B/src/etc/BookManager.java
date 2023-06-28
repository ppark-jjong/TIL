package etc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BookManager implements ApplicationContextAware, InitializingBean{
	private List<Book> bookList = null;
	private ApplicationContext context;
	Scanner s = new Scanner(System.in);
	
	public BookManager(List<Book> bookList) {
		super();
		this.bookList = bookList;
	}
	
	public List<Book> addBook() {
		Book book = (Book)context.getBean("book");
		bookList.add(book);
		return bookList;
	}
	
	public List<Book> changeBook() {
		System.out.println("이름을 변경할 도서명을 입력해주십시오.");
		String originName = s.nextLine();
		Book book;
		int i = 0;
		
		for (Iterator it = bookList.iterator(); it.hasNext(); i++) {
			book = (Book)it.next();
			if(book.getName().equals(originName)) {
				System.out.println("변경할 이름을 입력해주십시오.");
				book.setName(s.nextLine());
				bookList.set(i, book);
				System.out.println(originName + " 도서명을 " + book.getName() + "(으)로 변경하였습니다.");
				return bookList;
			}
		}
		System.out.println("일치하는 도서명이 없습니다.");
		return bookList;
	}
	
	public List<Book> deleteBook() {
		System.out.println("삭제할 도서명을 입력해주십시오.");
		String deleteName = s.nextLine();
		Book book;
		int i = 0;
		
		for (Iterator it = bookList.iterator(); it.hasNext(); i++) {
			book = (Book)it.next();
			if(book.getName().equals(deleteName)) {
				bookList.remove(i);
				System.out.println(deleteName + " 도서가 삭제되었습니다.");
				return bookList;
			}
		}
		System.out.println("일치하는 도서명이 없습니다.");
		return bookList;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;
	}
	
	
}
