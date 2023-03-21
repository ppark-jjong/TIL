package question;
import java.util.Scanner;
public class Bj14681 {
	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		
		int x = ex.nextInt();
		int y = ex.nextInt();
		
		if(x>0) {
			if(y>0)
				System.out.println("1");
			else
				System.out.println("4");
		}
		else {
			if(y>0)
				System.out.println('2');
			else
				System.out.println('3');
		}
	}

}
