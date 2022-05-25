package question;
import java.util.Scanner;

public class Bj2562 {
	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		int []arr = new int[9];
		
		for(int i =0; i<arr.length; i++) {
			int a = ex.nextInt();
			if(a>100)
				System.out.println("범위 안의 수가 아닙니다.ㅁ");
			arr[i] = a;
			
		}
		int big = 0;
		int score = 0 ;
		for(int i =0; i<arr.length; i++) {
			if(big<arr[i]) {
				big = arr[i];
				score = i+1;}
		}
		System.out.println(big+"\n"+ score);
	}

}
