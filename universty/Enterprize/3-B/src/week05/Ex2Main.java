package week05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import common.SmsSender;
import common.WorkUnit;

public class Ex2Main {

	public static void main(String[] args) {
		Executor executor;

		ApplicationContext context = new AnnotationConfigApplicationContext(BeanScopeEx.class);

		executor = (Executor) context.getBean("work", Executor.class);
		executor.work();
		executor = (Executor) context.getBean("work", Executor.class);
		executor.work();
		executor = (Executor) context.getBean("work", Executor.class);
		executor.work();

	}

}
