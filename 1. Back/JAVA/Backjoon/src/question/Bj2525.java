package question;
import java.util.Scanner;

public class Bj2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		
		int result = m+l;
		while(result>=60) {
			result-=60;
			h++;
		}
		if(h>=24) {
			h -=24;
		}
		System.out.println(h+" "+result);
		
	}

}
