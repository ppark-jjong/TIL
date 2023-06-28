package week06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
/*
week06 xml을 사용한 AOP*/
public class AdviceEx {
	
	// JoinPoint 매개변수 첫번쨰 인자 이용 Ex 1
	
	public void welcomeMessage(JoinPoint joinPoint) {

		System.out.println("반갑습니다." + joinPoint.getSignature().toString() + "시작합니다.");
		System.out.println("호출메서드(toLongString) : " + joinPoint.getSignature().toLongString());
		System.out.println("호출메서드(toShortString)." + joinPoint.getSignature().toShortString());
		System.out.println("대상 객체 : " + joinPoint.getTarget());
		System.out.println("========================================");

	}

	// 매개변수로는 핵심로직의 리턴타입을 받을 수 있께 최상위 클래스인 Object로 매개변수 생성 Ex2
	public void goodbyeMessage(Object retStr) {
		System.out.println("========================================");
		System.out.println("핵심 로직 구현 메서드에서 반환값 : " + retStr);
		System.out.println("메서드 종료");
	}
//Ex3
	public void exceptionProcess(Throwable ex) {
		System.out.println("========================================");
		System.out.println("예외 발생 !!, 예외 = " + ex.getMessage());
	}
	
//Ex4                             인자로  저장된 값을 데이터로 넘겨받는다 getArgs에 말이다 
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

	//Ex5
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
	//Ex 6
	public void argsEx(String objName) {
		System.out.println("=========================");
		System.out.println("[argsEx] : " + objName);
	}
}
