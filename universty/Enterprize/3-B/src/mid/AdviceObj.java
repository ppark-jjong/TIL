package mid;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Aspect
public class AdviceObj implements ApplicationContextAware {
	private ApplicationContext context = null;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;
	}

	@Pointcut("exection*(public * Mid.DrinkMahcine.drinkManufature(..))")
	private void pointcutDrink() {
	}

	@Around("pointcutDrink()")
	public void logWrite(ProceedingJoinPoint joinpoint) throws Throwable {
		DrinkMachine obj = (DrinkMachine) context.getBean("drinkMachine");
		Object[] result = joinpoint.getArgs();
		int num = Integer.parseInt(result[0].toString());
		String drink = obj.getDrinkKeyList().get(num);
		System.out.println("======" + drink + "=======");

		try {
			Object ret = joinpoint.proceed();

		} finally {
			System.out.println("주문하신 " + drink + "가 왼성되었습니다. ========");
		}
	}
}
