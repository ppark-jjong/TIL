package week04;

import org.springframework.beans.factory.annotation.Required;

public class RequiredEx {
	private int num;

	@Required
	public void setNum(int num) {
		this.num = num;
		System.out.println("setNum() : " + num);
	}
}
