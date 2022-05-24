package question;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Bj5613 {
	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		int result = ex.nextInt();
		String a = "";
		
		while(true) {
			a= ex.next();
			if(a.equals("=")) {
				break;
				}
			
			int num2 = ex.nextInt();			
			if(a.equals("+")) {
				result += num2; 
			}
			else if(a.equals("-")) {
				result -=num2;
			}
			else if(a.equals("*")) {
				result *=num2;
			}
			else if(a.equals("/")) {
				result /= num2;
			}
		}
		System.out.println(result);
	}
}

