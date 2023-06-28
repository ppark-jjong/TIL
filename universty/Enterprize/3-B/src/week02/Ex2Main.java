package week02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import common.SmsSender;

//XML 파일을 이용한 스프링 컨테이너 활용
public class Ex2Main {
	public static void main(String[] args) {

////	1. 	xml 설정 파일을 이용한 컨테이너 생성 방법
		ApplicationContext ctx = new FileSystemXmlApplicationContext("XML/week02/Ex2.xml");
		InjectionEx g1 = (InjectionEx) ctx.getBean("injectionEx");
		g1.write();

	}

}
