package week11;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex4Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Member member;
		MemberDao dao = (MemberDao) ctx.getBean("memberDao");

		member = dao.selectInfoID(1, "std1");

		System.out.println("===== selectInfoID() 메서드 실행 결과 =====");
		System.out.println("ID : " + member.getId());
		System.out.println("Email : " + member.getEmail());
		System.out.println("password : " + member.getPassword());
		System.out.println("name : " + member.getName());
		System.out.println("date : " + member.getRegisterDateTime());
		System.out.println("==========================");
	}
}
