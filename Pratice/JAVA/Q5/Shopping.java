import java.util.LinkedList;
import java.util.Scanner;

public class Shopping {
    Scanner scanner = new Scanner(System.in);
    LinkedList<Cart> cartArray = new LinkedList<Cart>();

    public LinkedList<Cart> getCartArray() {
        return cartArray;
    }

    public int shoppingMenu() {
        System.out.print("--------------------\n1. 카트 임대\n2. 카드 반납\n3. 쇼핑 종료\n동작 입력 : ");
        return scanner.nextInt();
    }

    public Cart rentCart() {
        System.out.print("--------------------\n(임대)사용자 이름 입력 : ");
        String name = scanner.next();

        for (Cart cart : cartArray) {
            if (cart.getName().equals(name)) {
                return cart;
            }
        }

        Cart cart = new Cart(name);
        cartArray.add(cart);
        return cart;
    }

    public void returnCart() {
        System.out.print("--------------------\n(반납)사용자 이름 입력 : ");
        String name = scanner.next();

        for (Cart cart : cartArray) {
            if (cart.getName().equals(name)){
                cartArray.remove(cart);
                break;
            }
        }
    }

    public int cartMenu() {
        System.out.print("--------------------\n1. 카트에 상품 추가\n2. 카트에 수량 변경\n3. 카트 상품 제거\n4. 카트 상품 출력\n5. 카트 관련 동작 종료\n카트 동작 입력 : ");
        return scanner.nextInt();
    }

    public void cartAction(Cart cart, int cartMenuSelect){
        if (cartMenuSelect == 1) {
            System.out.println("--------------------\n추가할 상품 정보 입력");
            System.out.print("상품 이름 : ");
            String itemName = scanner.next();
            System.out.print("상품 가격 : ");
            int itemPrice = scanner.nextInt();
            System.out.print("상품 수량 : ");
            int itemCount = scanner.nextInt();

            cart.addCart(itemName, itemPrice, itemCount);
        }
        else if (cartMenuSelect == 2) {
            System.out.println("--------------------\n수량을 추가할 상품 정보 입력");
            System.out.print("상품 이름 : ");
            String itemName = scanner.next();
            System.out.print("상품 수량 : ");
            int itemCount = scanner.nextInt();

            cart.updateCart(itemName, itemCount);
        }
        else if (cartMenuSelect == 3) {
            System.out.println("--------------------\n제거할 상품 정보 입력(전부 : all)");
            System.out.print("상품 이름 : ");
            String itemName = scanner.next();
            if (itemName.equals("all")){
                cart.emptyCart();
                return;
            }
            cart.removeCart(itemName);
        }
        else if (cartMenuSelect == 4) {
            cart.printItems();
        }
    }
}