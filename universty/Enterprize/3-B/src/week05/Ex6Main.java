package week05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex6Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("file:XML/week05/Ex6.xml");
		PropertyEx m = (PropertyEx) context.getBean("pEx");
		System.out.println(m.toString());
		context.close();

	}

}
