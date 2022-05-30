package question;
import java.util.Arrays;
import java.util.Scanner;

public class Bj10989 {
	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		
		int len = ex.nextInt();
		int []arr = new int[len];
		for(int i =0; i<len; i++) {
			arr[i] = ex.nextInt();
		}
		Arrays.sort(arr);
		for(int i =0; i<len; i++) {
		System.out.println(arr[i]);	
		}
	}

}
