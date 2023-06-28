package week02;

import java.beans.JavaBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import common.SmsSender;

//해당 클래스는 컨테이너가 사용할 자바 환경 설정 클래스이다.
@Configuration
public class AppContext {
	
	//Bean 어노테이션 밑의 메서드를 이용하여 빈 객체를 만들어라.
	@Bean
	//메서드의 이름이 빈 객체의 이름으로 사용
	public SmsSender smsSend() {
		SmsSender g = new SmsSender();
		return g;
	}
}
