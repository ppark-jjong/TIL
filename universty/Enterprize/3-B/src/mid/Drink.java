package mid;

import java.util.Scanner;

public class Drink {
	private int price;
	private String maker;
	Scanner in = new Scanner(System.in);
	
	public void inputInfo(String drink) {
		System.out.println(drink + "가격 : ");
		price = in.nextInt();
		in.nextLine();
		System.out.println(drink + "상품명 : ");
		maker = in.nextLine();
	}

	public int getPrice() {
		return price;
	}

	public String getMaker() {
		return maker;
	}
	
}
