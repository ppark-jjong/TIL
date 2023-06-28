package week05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import common.SmsSender;


@Component("exeObj") //Executor를 자동 스캔 했을 떄 exeObj라는 빈 객체로 자동 등록하겠다
@Scope("prototype") //빈 scope를 설정하여 해당 클래스가 빈으로 설정될 때는 무조건 prototype 객체로 선언된다.
public class Executor {
	
	@Autowired
	private SmsSender smsSend;

	//smsSend를 autowired로 가지고 왔기 떄문에 무조건 set 함수 설정
	public void setSmsSend(SmsSender smsSend) {
		this.smsSend = smsSend;
	}
	
	public void work() {
		System.out.println(toString() + "work : " + smsSend);
	}
	
	//Ex 3 실습
	public void init() {
		System.out.println("init 메소드 동작");
	}
	public void destroy() {
		System.out.println("close 메소드 동작");
	}
}
