package week05;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class InterfaceEx implements BeanNameAware, ApplicationContextAware,InitializingBean {

	private String beanName;
	private ApplicationContext context;

	@Override // 빈 객체 확인 메서드 => InitializingBean 인터페이스의 메서드를 오버라이딩
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() 메서드 실행 ");
		System.out.println("컨테이너 : " + context.getId());
		System.out.println("smsSend: " + context.getBean("smsSend"));
		System.out.println(" 빈이름 :  " + beanName.toString());
		System.out.println("=============================================");

	}

	@Override // 빈 객체를 생성해서 불러온다 => ApplicationContextAware 인터페이스의 메서드로 
	//빈 객체가 스프링컨테이너에 직접 접근하여 빈 객체 생성
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0; //ApplicationContext 객체를 직접 선언하여 빈 객체 설정을 해준다
	}

	@Override // 빈 객체 이름 설정 메서드 -> 보통 클래스 이름이 bean name으로 설정된다 (BeanNameAware 인터페이스 메서드)
	public void setBeanName(String arg0) {
		this.beanName = arg0;
	}

	public void init() {
		System.out.println("init 메소드 동작");
		System.out.println("=============================================");

	}

	public void close() {
		System.out.println("=============================================");
		System.out.println("close 메소드 동작");
	}

}
