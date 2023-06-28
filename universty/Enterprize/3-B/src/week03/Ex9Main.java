package week03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import common.SmsSender;

public class Ex9Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new GenericXmlApplicationContext("file:" + "XML/week03/Ex9.xml");
		AutoDependecy g1 = (AutoDependecy) ctx.getBean("autoDependecy", AutoDependecy.class);

	}

}
