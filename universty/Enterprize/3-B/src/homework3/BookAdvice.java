package homework3;

import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Aspect
public class BookAdvice implements ApplicationContextAware {
	private ApplicationContext ctx = null;

	@Pointcut("execution(public * homework3.BookManager.book*(..))")
	private void pointcutBook() {
	}

	@AfterReturning(pointcut = "pointcutBook()")
	public void printObj() {
		BookDao dao = (BookDao) ctx.getBean("bookDao");
		List<Book> books = dao.selectAll();
		if(books == null) {
			System.out.println("출력할 BookList가 없습니다");
			return;
		}
		Iterator it = books.iterator();
		Book book;
		System.out.println("========BookList 결과========");
		while(it.hasNext()) {
			book = (Book)it.next();
			System.out.println("책 이름 : " + book.getName());
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.ctx = arg0;
	}
	
}
