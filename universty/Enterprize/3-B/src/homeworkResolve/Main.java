package homeworkResolve;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("file:XML/homeworkResolve/main.xml");

		StdManager m= (StdManager) context.getBean("stdManag");
	
		
		context.close();
	}

}
