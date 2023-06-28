package week04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex8Main {

	public static void main(String[] args) {
		/*
		 * static final String xmLPath = "xml/week03/";
		 */
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanAnnotationEx.class);
		CodeBaseEx m = (CodeBaseEx) context.getBean("codeAutoEx");
		System.out.println("CodeBaseEx : " + m + ", num : " + m.getWorkUnit().getNum());
	}

}
