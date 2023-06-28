package week04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex4Main {

	public static void main(String[] args) {
		/*
		 * static final String xmLPath = "xml/week03/";
		 */ ApplicationContext context = new GenericXmlApplicationContext("file:XML/week04/Ex4.xml");

		AutowiredEx m = (AutowiredEx) context.getBean("autowiredEx");
		m.objInfo();
	}

}
