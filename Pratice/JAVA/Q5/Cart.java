import java.util.LinkedList;

public class Cart {
    String name;
    LinkedList<Item> itemArray = new LinkedList<Item>();

    public Cart(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCart(String itemName, int itemPrice, int itemCount) {

        for (Item item : itemArray) {
            if (item.getName().equals(itemName)) {
                item.setCount(item.getCount() + itemCount);
                return;
            }
        }

        itemArray.add(new Item(itemName, itemPrice, itemCount));
    }

    public void updateCart(String itemName, int itemCount) {
        for (Item item : itemArray) {
            if (item.getName().equals(itemName)) {
                item.setCount(itemCount);
            }
        }
    }

    public void removeCart(String itemName) {
        for (Item item : itemArray) {
            if (item.getName().equals(itemName)) {
                itemArray.remove(item);
            }
        }
    }

    public void emptyCart() {
        itemArray.clear();
    }

    public void printItems() {
        System.out.println("--------------------");
        if (itemArray.isEmpty())
            System.out.println("상품이 존재하지 않습니다.");
        for (Item item : itemArray) {
            System.out.println( "\n" +
                "\n상품 이름 : " + item.getName() + 
                "\n상품 가격 : " + item.getPrice() + 
                "\n상품 수량 : " + item.getCount());
        }
    }
}
