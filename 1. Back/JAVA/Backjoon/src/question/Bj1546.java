package question;
import java.util.Scanner;

public class Bj1546 {
	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		int len = ex.nextInt();
		double result = 0;
		double average;
		float big = 0;
		double score=0;
		
		float [] arr = new float[len];
		for(int i =0; i<arr.length; i++) {
			arr[i] = ex.nextInt();
			if(arr[i]>big) {
				big = arr[i];
			}
			
		}
		for(int i =0; i<arr.length; i++) {
			
			score = arr[i]/big*100;
			result+=score;
		}
		average = result/len;
		System.out.println(average);
		
	}

}
