package week06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex1Main {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("file:XML/week06/Ex1.xml");
		PointcutObj obj = (PointcutObj) context.getBean("pObj");
		obj.businessLogic();
	}

}
