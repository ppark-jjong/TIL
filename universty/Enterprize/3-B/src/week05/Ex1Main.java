package week05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import common.SmsSender;
import common.WorkUnit;

public class Ex1Main {

	public static void main(String[] args) {
		
		//BeanScope의 빈 객체와 importResource파일 xml을 동시에 환경설정 클래스로 관리 및 받는다.
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanScopeEx.class);
		
		// 다른 참조 값을 출력
		//Scope = prototype을 지정하면 getBean 할때마다 새로운 빈 객체가 생성된다
		 System.out.println((WorkUnit) context.getBean("unit"));
		 System.out.println((WorkUnit) context.getBean("unit"));
		 
		 // 같은 참조 값을 출력
		 // 기본 디폴트 값 싱글톤 빈 생성
		 System.out.println((SmsSender) context.getBean("smsSend"));
		 System.out.println((SmsSender) context.getBean("smsSend"));

	}

}
