package homework2;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BookManager implements ApplicationContextAware{
	private List<StdBook> blist = null;
	private ApplicationContext context = null; // 자바 빈을 주입 받을 컨테이너 객체 초기화
	Scanner sc = new Scanner(System.in);

	public BookManager(List<StdBook> blist) {
		super();
		this.blist = blist;
	}

	public BookManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<StdBook> addBook() {
		System.out.println("추가할 도서명을 입력해주십시오 : ");
		String name= sc.nextLine();
		StdBook bkmember = (StdBook) context.getBean("stdBook");
		bkmember.setName(name);
		blist.add(bkmember);
		System.out.println(name + "의 책이 추가되었습니다.");
		return blist;
	}

	public List<StdBook> renameBook() {
		System.out.println("변경할 책 이름을 적으시오 : ");
		String name = sc.nextLine();
		int i = 0;

		StdBook findbook;
		for (Iterator it = blist.iterator(); it.hasNext(); i++) {
			findbook = (StdBook) it.next();
			if (name.equals(findbook.getName())) {
				System.out.println("변경할 이름을 적으시오");
				findbook.setName(sc.nextLine());
				blist.set(i, findbook);
				System.out.println(name + " -> " + findbook.getName() + "로 책 이름을 정상 변경하였습니다");
				return blist;
			}
		}
		System.out.println("책을 찾지 못하였습니다.");
		return blist;
	}

	public List<StdBook> deleteBook() {
		System.out.println("삭제할 책 이름을 적으시오 : ");
		String named = sc.nextLine();
		StdBook findBook;
		int i = 0;

		for (Iterator it = blist.iterator(); it.hasNext(); i++) {
			findBook = (StdBook) it.next();
			if (findBook.getName().equals(named)) {
				blist.remove(i);
				System.out.println(named + "가 정상 삭제 되었습니다.");
				return blist;
			}
		}
		System.out.println("책을 찾지 못하였습니다.");
		return blist;
	}

//	@Override
//	public void afterPropertiesSet() throws Exception {
//	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;
	}
}
