package question;
import java.util.Scanner;
public class Bj1297 {

	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		int a = ex.nextInt();
		int b = ex.nextInt();
		int c = ex.nextInt();
		
		double result = Math.sqrt(Math.pow(a,2)/(Math.pow(b,2) + Math.pow(c, 2)));//math == java내장함수
		
		System.out.println((int)a*result + " " +(int) b*result);
	}

}
