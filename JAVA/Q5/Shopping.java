package Homeclass;
import java.util.*;


public class Shopping {
	
	Scanner ex = new Scanner(System.in);
	LinkedList<Cart> carts= new LinkedList<Cart>();
	private Item Item;

	public void shoppingMenu() {
		System.out.println("1. 카드임대 \n 2. 카트 반납 \n 3. 쇼핑종료 \n 동작 입력 : ");
		int a = ex.nextInt();
		
		if(a==1)
			rentCart();
		else if(a==2) {
			System.out.println("반납하는 사용자 이름을 입력>>");
			String name = ex.next();
			for(int i =0; i<carts.size(); i++) {
				Cart cart1 = carts.get(i);
				String name1 = cart1.getName();
				if(name == name1) {
				returnCart(cart1);}
			}
		}
		else {
			System.out.println("쇼핑을 종료합니다.");
		}
	}

	public Cart rentCart() {//사용자 이름에 따른 객체를 반환
		System.out.print("(임대)사용자 이름 입력 >>");
		String name = ex.next();
		Cart cart = new Cart(name);
		carts.add(cart); //사용자 이름으로 객체를 생성하고 그 객체를 배열에 추가
		return cart;
	}
	public void returnCart(Cart cart) {
		for(int i =0; i<carts.size();i++) {
			Cart cart1 = carts.get(i);
			if(cart == cart1)
				carts.remove(cart);
	}
	}
	public void cartMenu(Cart cart) {//렌트카트 메서드로 받은 객체를 사용해야한다.
		System.out.println("------------------------ \n 1. 카트에 상품 추가 \n 2. 카트에 수량 추가 \n 3. 카트 상품 제거 \n 4. 카트 상품 출력 \n 5. 카트 관련 동작 종료 \n 카드 동작 입력 : ");
		int num = ex.nextInt();
		if(num==1) {
			
		}
	}
	public void cartActionAdd(Cart cart) {
		carts.add(cart.addCart(Item item));
	
	}
	public void cartAction()
	{
		}
	}
