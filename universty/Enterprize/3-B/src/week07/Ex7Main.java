package week07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex7Main {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("file:XML/week07/Ex7.xml");
		PointcutObj obj = (PointcutObj) context.getBean("pObj");
		try{
			obj.throwNeedLogic("WorkUnit");
		}catch (Exception e) {}
}

}
