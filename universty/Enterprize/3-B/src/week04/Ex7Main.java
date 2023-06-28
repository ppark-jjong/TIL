package week04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex7Main {

	public static void main(String[] args) {
		/*
		 * static final String xmLPath = "xml/week03/";
		 */
		ApplicationContext context = new GenericXmlApplicationContext("file:XML/week04/Ex7.xml");
		CodeBaseEx m = (CodeBaseEx) context.getBean("autoEx");
		m.info();
	}

}
