package report2;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BookAdvice {
	//해당 어노테이션 아래에 있는 메서드 이름은 Pointcut의 이름이 된다
	@Pointcut("execution(public * report2.BookManager.book*(..))")
	public void pointcutBook() {}
	
	//생성자로 외부 txt 파일을 주입 받는다 
	FileWriter fw = null;
	public BookAdvice(String dst) throws IOException{
		fw = new FileWriter(dst, true);
	}
	
	
	//모든 함수들이 호출되기 전 날짜 메서드를 호출해줘야 하는 Aspect
	@Before("pointcutBook()")
	public void logWrite(JoinPoint joinPoint) throws IOException{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E) a hh:mm:ss z");
		String dateInfo = sdf.format(d);
		
		//JoinPoint로 반환된 객체 확인용 메서드
		String callName = joinPoint.getSignature().toShortString();
		fw.write(dateInfo + " : " + callName + "호출됨 \n");
	}
	
	//모든 함수들이 호출되고 난 후 BookList를 호출하는 메서드
	@AfterReturning(pointcut="pointcutBook()", returning = "retObj")
	public void printObj(Object retObj) {
		List<Book> books = (List<Book>)retObj;
		if(books == null) {
			System.out.println("출력할 List가 존재하지 않음");
			return;
		}
		Iterator it = books.iterator();
		Book book;
		System.out.println("=========저장결과=========");
		while(it.hasNext()) {
			book = (Book) it.next();
			System.out.println("책 이름 : " + book.getBookName());
		}
	}
	
	public void logClose() throws IOException {
		fw.close();
	}
}
