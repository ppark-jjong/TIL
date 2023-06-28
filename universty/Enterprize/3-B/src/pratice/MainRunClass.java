package pratice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainRunClass {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("file:XML/pratice/ListB.xml");

		ListP main = (ListP) ctx.getBean("ListConst", ListP.class);

	}

}
