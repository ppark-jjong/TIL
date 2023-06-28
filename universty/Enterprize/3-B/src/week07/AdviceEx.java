package week07;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/*
week07
@Aspect 클래스로 지정
Aspect로 생성할 때 지정해야 될 메서드는
Pointcut 메서드, Advice 메서드*/
@Aspect
public class AdviceEx {
	//pointcut의 이름은 메서드 name으로 설정하고 execution은 따로 설정한다
	@Pointcut("execution(public * week07..*(..))")
	//메서드의 이름은 Pointcut의 Id가 된다
	//메서드 명은 Advice 관련 어노테이션에서 Pointcut 이름으로 사용된다.
	//리턴타입은 반드시 void 타입이여야 한다.
	private void pointcutName() {
		
	}
	
	@Before("pointcutName()")
	public void welcomeMessage(JoinPoint joinPoint) {

		System.out.println("반갑습니다." + joinPoint.getSignature().toString() + "시작합니다.");
		System.out.println("호출메서드(toLongString) : " + joinPoint.getSignature().toLongString());
		System.out.println("호출메서드(toShortString)." + joinPoint.getSignature().toShortString());
		System.out.println("대상 객체 : " + joinPoint.getTarget());
		System.out.println("========================================");

	}
	
	//returning의 변수명과 해당 메서드의 매개변수 변수명과 일치해야함
	//메서드가 정상 실행 후 실행되는 AfterReturning
	@AfterReturning(pointcut = "pointcutName()", returning = "retStr")
	public void goodbyeMessage(Object retStr) {
		System.out.println("========================================");
		System.out.println("핵심 로직 구현 메서드에서 반환값 : " + retStr);
		System.out.println("메서드 종료");
		}
	
	//메인메서드가 예외발생하면 실행됨
	@AfterThrowing(pointcut = "pointcutName()", throwing = "ex")
	public void exceptionProcess(Throwable ex) {
		System.out.println("========================================");
		System.out.println("예외 발생 !!, 예외 = " + ex.getMessage());
	}
	
	//예외가 발생하던 안하던 간에 pointcut 실행 후 실행됨
	@After("pointcutName()")
	public void afterFinally(JoinPoint joinPoint) {
		System.out.println("========================================");
		System.out.println("[Ex4] joinPoint.getArgs.length) : " + joinPoint.getArgs().length);
		//getArgs는 인자값을 반환한다.
		Object[] result = joinPoint.getArgs();
		for (int i = 0; i < result.length; i++) {
			System.out.println("[Ex4] joinPoint.getArgs.toString) : " + result[i].toString());
		}
		System.out.println("예외 발생 여부와 상관없이 적용되는 메서드 실행 완료");
	}

	@Around("pointcutName()")
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable{
		//pointcut 메서드 실행전 코드 실행
		String signatureString = joinPoint.getSignature().toShortString();
		System.out.println(signatureString + "시작합니다");
		long start = System.currentTimeMillis();
		//pointcut 메서드 실행 후 코드 실행
		try {
			System.out.println("=======================");
			//반드시 try블럭에서 대상 메서드를 실행
			//proceed() 메서드를 호출해야만 Main에 있는 throwNeedLogin이 호출된다. == pointcut 메서드가 실행 될 수 있게 해줌
			Object result = joinPoint.proceed();
			System.out.println(result);
		}
		finally {
			//finally 블럭을 사용하지 않을 경우 대상메서드 실행 후 코드가 실행되지 않음
			long finish = System.currentTimeMillis();
			System.out.println("=========================");
			System.out.println(signatureString + "종료");
			System.out.println(signatureString + "실행 시간 : " + (finish - start)+"ms");
		}
	}

	public void argsEx(String objName) {
		System.out.println("=========================");
		System.out.println("[argsEx] : " + objName);
	}
}
