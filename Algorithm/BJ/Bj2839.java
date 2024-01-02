package question;
import java.util.Scanner;

public class Bj2839 {
	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		
		int a = ex.nextInt();
		int c = 0;
		if(a>4) {
			if(a%5 != 0) {
				c = a/5;
				int b = a%5;
				c+=b/3;
				
				if(b%3!=0) {
					c++;		
				}
				
			}
			else {
				c = a/5;
			}
		}
		else {
			c = -1;
		}
		System.out.println(c);
	}

}
