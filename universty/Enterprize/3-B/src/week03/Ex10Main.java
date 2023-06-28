package week03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import common.SmsSender;

public class Ex10Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new GenericXmlApplicationContext("file:" + "XML/week03/Ex10.xml");
		// 기본 생성자가 필요함 왜냐하면 property 태그를 이용하여 객체를 생성하는데 bean 객체에서는 자동으로 기본생성자를 이용한다.
		// 따라서 기본 생성자가 필요하다.
		//collectionEx는 직접 property 선언으로 
		// SmsSend는 autowire로 찾아냄
		AutoDependecy g1 = (AutoDependecy) ctx.getBean("autoDependecy", AutoDependecy.class);

	}

}
