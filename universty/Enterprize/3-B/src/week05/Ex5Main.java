package week05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex5Main {

	public static void main(String[] args) {
		// 객체 소멸을 위하여 AbstractApplicationContext 타입의 컨테이너 생성
		AbstractApplicationContext context = new GenericXmlApplicationContext("file:XML/week05/Ex5.xml");
		InterfaceEx m = (InterfaceEx) context.getBean("interfaceEx");
		context.close();

	}

}
