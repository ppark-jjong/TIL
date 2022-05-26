package Homeclass;

public class Item {
	private int quatity; int price; 
	private String name;
	public Item(String name, int quatity, int price) {
		this.name = name;
		this.quatity = quatity;
		this.price = price;
	}
	public int getQuatity() {
		return quatity;
	}
	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
}
