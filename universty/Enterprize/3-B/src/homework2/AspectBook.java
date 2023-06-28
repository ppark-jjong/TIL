package homework2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.aspectj.lang.JoinPoint;

import etc.Book;

public class AspectBook {

	public void log(JoinPoint joinPoint) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd (EEE) hh:mm:ss a zzz");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		Date now = new Date();
		dateFormat.format(now);
		System.out.println(dateFormat.toString() + " : " + joinPoint.getSignature().toString() + " 호출됨 ");
	}
//after returning
	public void printBookList(List<StdBook> blist) {
		StdBook book;
		System.out.println("현재 책 리스트 입니다.");
		System.out.println("==========");
		for (int i = 0; i < blist.size(); i++) {
			book = blist.get(i);
			System.out.println(book.getName());
		}
	}

}
