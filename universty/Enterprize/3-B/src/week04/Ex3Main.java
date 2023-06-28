package week04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex3Main {

	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext("file:XML/week04/Ex3.xml");

		AutowiredEx m = (AutowiredEx) context.getBean("autowiredEx");
//		프로퍼티 값을 설정하면 그 값에 대한 set 메소드가 출력된다
		
		m.objInfo();
	}

}
