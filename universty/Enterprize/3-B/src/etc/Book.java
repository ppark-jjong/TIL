package etc;

import java.util.Scanner;

public class Book {
	private String bookName;
	Scanner s = new Scanner(System.in);

	public String getName() {
		return bookName;
	}

	public void setName(String name) {
		this.bookName = name;
	}
	
	public void inputBook() {
		System.out.println("추가할 도서명을 입력해주십시오 : ");
		bookName = s.nextLine();
		System.out.println(bookName + " 추가되었습니다.");
	}
}
