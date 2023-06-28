package etc;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.JoinPoint;

public class BookAdvice {
	
	public void log(JoinPoint joinPoint) {
		SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf5 + "///" + joinPoint.getSignature().toString() + " 호출됨");
	}
	
	public void printBookList(List<Book> bookList) {
		Book book;
		Iterator it = bookList.iterator();
		System.out.println("==========");
		System.out.println("현재 도서 목록 :");
		while(it.hasNext()) {
			book = (Book)it.next();
			System.out.println(book.getName());
		}
	}
}
