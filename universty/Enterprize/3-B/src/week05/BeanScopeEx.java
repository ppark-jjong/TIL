package week05;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

import common.WorkUnit;

//환경설정 클래스이다
@Configuration
@ImportResource("file:xml/week05/Ex2.xml")
public class BeanScopeEx {
	
	//Ex1 실습
	@Bean
	@Scope("prototype")
	public WorkUnit unit() {//빈 스코프 설정
		return new WorkUnit();
	}
	
	//Ex 2 실습
	@Bean(autowire = Autowire.BY_TYPE) //빈에 속한 클래스의 property (속성)에 타입으로 자동 autowire
	public Executor work() {
		return new Executor();
	}
}
