package week04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new GenericXmlApplicationContext("file:XML/week04/Ex1.xml");
		
		RequiredEx m = (RequiredEx) context.getBean("requiredEx");
//		프로퍼티 값을 설정하면 그 값에 대한 set 메소드가 출력된다
		System.out.println(m);

	}

}
