package pratice;

import java.util.List;

import common.SmsSender;

public class ListP {
	private List<Double> doubleList;
	private List<SmsSender> constList;

	// 생성자 자바 빈 접근
	public ListP(List<SmsSender> constList, List<Double> doubleList) {
		this.constList = constList;
		this.doubleList = doubleList;
		System.out.println("생성자로 자바빈 접근");
		for (int i = 0; i < this.constList.size(); i++)
			System.out.println("[" + i + "] 객체 : " + this.constList.get(i));
		for(int i =0; i<this.doubleList.size(); i++)
			System.out.println("[" + i + "] 객체 : " + this.doubleList.get(i));
	}

	public ListP() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
