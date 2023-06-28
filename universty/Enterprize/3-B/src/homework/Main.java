package homework;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("file:XML/homework/main.xml");

		StdManager stdManager = (StdManager) context.getBean("stdManager");

		for (int i = 0; i < stdManager.getNumStudents(); i++) {
			stdManager.addStudentInfo();
		}

		context.close();
	}

}
