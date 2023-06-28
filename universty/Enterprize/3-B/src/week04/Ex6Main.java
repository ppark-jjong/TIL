package week04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import common.SmsSender;

public class Ex6Main {

	public static void main(String[] args) {
		// XMl 생성과 다르게 자바 빈은 컨테이너 객체 타입과 매개변수 값이 다르다
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanAnnotationEx.class);

		CodeBaseEx m = (CodeBaseEx) context.getBean("autoEx");
		m.info();
	}

}
