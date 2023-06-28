package mid;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:mid/main.xml");
		DrinkMachine m = (DrinkMachine) context.getBean("drinkMachine");
		int num;
		while(true) {
			num = m.printMenu();
			if(num==3) {
				System.out.println("프로그램 종료");
				break;
			}
			if(num < 1 || num >2) {
				System.out.println("주문 번호를 잘못 선택");
				continue;
			}
			m.drinkManaufacture(num-1);
		}
		context.close();
	}

}
