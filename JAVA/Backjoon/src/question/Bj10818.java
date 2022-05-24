package question;

import java.util.Scanner;

public class Bj10818 {
	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		
		int score = ex.nextInt();
		
		int [] arr = new int[score];
		
		for(int i =0; i<score; i++) {
			arr[i] = ex.nextInt();
		}
		int big = arr[0];
		int small = arr[0];
		
		for(int i =1; i<score; i++) {
			if(arr[i]>big)
				big = arr[i];
		}
		for(int i =1; i<score; i++) {
			if(arr[i]<small)
				small = arr[i];
		}	
		System.out.println(small + " " + big);
	}
}
