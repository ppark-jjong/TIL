package week05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex4Main {

	public static void main(String[] args) {
		// 객체 소멸을 위하여 AbstractApplicationContext 타입의 컨테이너 생성
		AbstractApplicationContext context = new GenericXmlApplicationContext("file:XML/week05/Ex4.xml");

		Executor m1 = (Executor) context.getBean("exeObj");
		m1.work();
		Executor m2 = (Executor) context.getBean("exeObj");
		m2.work();
		context.close();

	}

}
