package classFile;

public class Item {
	String itemName;
	String maker;
	int price;

	public Item(String itemName, String maker, int price) {
		super();
		this.itemName = itemName;
		this.maker = maker;
		this.price = price;
	}

	public Item() {
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
