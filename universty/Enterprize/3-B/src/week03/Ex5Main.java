package week03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex5Main {

	public static void main(String[] args) {
		// 파일명은 띄어씌기를 허용하지 않는다 file: xml~~~ 가 아니고 file:xml~~~ 이렇게다
		ApplicationContext ctx = new GenericXmlApplicationContext("file:" + "XML/week03/Ex5.xml");
		CollectionEx g1 = (CollectionEx) ctx.getBean("collectionEx");
	}

}
