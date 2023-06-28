package mid;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;

public class DrinkMachine implements InitializingBean {
	private Map<String, Drink> objMap;
	private List<String> drinkKeyList = null;
	Scanner in = new Scanner(System.in);

	public DrinkMachine() {
	}

	public DrinkMachine(Map<String, Drink> objMap) {
		this.objMap = objMap;
		drinkKeyList = new LinkedList();
	}

	private void setKeyList() {
		String keyStr;
		Set key = this.objMap.keySet();
		Iterator<String> it = key.iterator();
		Drink drink;
		// 키 이름으로 쓸 내용을 입력 받아 키 List와 Map의 key에 적용시킴
		while (it.hasNext()) {
			keyStr = it.next();
			drinkKeyList.add(keyStr);
			drink = (Drink) objMap.get(keyStr);
			drink.inputInfo(keyStr);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Iterator it = drinkKeyList.iterator();
		Drink drink;

		System.out.println("===============");
		String info;
		while (it.hasNext()) {
			info = (String) it.next();
			drink = (Drink) objMap.get(info);
			System.out.println(info + " 음료 가격 : " + drink.getPrice());
			System.out.println(info + " 음료 상표 : " + drink.getMaker());
		}

	}

	public int printMenu() {
		System.out.println("==============");
		System.out.println("커피 주문 [1]");
		System.out.println("라떼 주문 [2]");
		System.out.println("프로그램 종료 [3]");
		System.out.println(" 번호 선택 : ");
		
		return in.nextInt();
	}

	public List<String> getDrinkKeyList(){
	return drinkKeyList;
	}
	
	//PointCut 메서도르 사용될 메서드
	public void drinkManaufacture(int num) {
		String key = drinkKeyList.get(num);
		System.out.println(key + "를 준비 중입니다,");
	}
	
	

}
