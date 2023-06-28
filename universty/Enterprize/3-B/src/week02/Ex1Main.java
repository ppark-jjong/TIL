package week02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import common.SmsSender;

//XML 파일을 이용한 스프링 컨테이너 활용
public class Ex1Main {
	public static void main(String[] args) {

//		1. file을 이용한 방법
//		ApplicationContext ctx 
//		= new GenericXmlApplicationContext("file:xml/week02/Ex1.xml");

//		
////	2. 	xml 설정 파일을 이용한 컨테이너 생성 방법
//		ApplicationContext ctx 
//		= new FileSystemXmlApplicationContext("XML/week02/Ex1.xml");
//		
		
//		//빈 객체의 id로 get()를 이용한 정보 획득
//		SmsSender g1 = (SmsSender)ctx.getBean("smsSend");
//		SmsSender g2 = (SmsSender)ctx.getBean("smsSend");

		// 2. 자바 환경설정 클래스를 이용한 컨테이너 설정법 (바이트 class 를 이용함)
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

		SmsSender g1 = (SmsSender) ctx.getBean("smsSend");
		SmsSender g2 = (SmsSender) ctx.getBean("smsSend");

		// 싱글톤 확인 (빈 태그 하나당 하나의 객체만 생성하는 디자인 패턴)
		System.out.println("(g1==g2) = " + (g1 == g2));
	
	}

}
