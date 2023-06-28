package week04;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import common.SmsSender;

@Configuration // 설정 클래스라는 것 이 클래스는 자바빈 설정 클래스이다.
@ImportResource("file:XML/week04/Ex7.xml") //xml로 자바빈을 생성
public class BeanAnnotationEx {

	@Bean(name = "smsSend") // 이 빈객체의 이름은 메서드 이름인 send() 가된다 다른 이름을 이용하고 싶으면 name 속성 값을 이용한다.
	public SmsSender send() {
		return new SmsSender();
	}
	
	@Bean(name = "autoEx", autowire = Autowire.BY_NAME) //동일한 이름의 타입을 주입
//	@Bean(name = "autoEx", autowire = Autowire.BY_TYPE) //동일한 타입의 타입을 주입
	public CodeBaseEx autoEx() {
		return new CodeBaseEx();
	}

	@Bean(name = "codeAutoEx", autowire=Autowire.BY_NAME)
	public CodeBaseEx importResourecEx() {
		return new CodeBaseEx();
	}
}
