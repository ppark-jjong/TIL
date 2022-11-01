package Homework;

import java.util.Random;
import java.util.Scanner;

public class Q4 {
	public int computer() {
		Random r = new Random();
		int c = r.nextInt(3);
		
		switch(c) {
		case 0:
			System.out.println("????? : ????");
			break;
		case 1:
			System.out.println(("????? : ????"));
			break;
		case 2:
			System.out.println("????? : ??");
			break;
		}
		return c;
	}
	
	
	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		Q4 cal = new Q4();
			while(true) {
				System.out.print("????(0), ????(1), ??(2), ????(-1) ?? ???? ????? ??????? >>");
				int myNum = ex.nextInt();
				int comNum = cal.computer();
				if(myNum>2&&myNum<-1) {
					System.out.println("??? ??????????.");
				}
				else {
					switch(myNum) {
					case 0:
						if (comNum == 0) {
							System.out.println("???????.");
						break;
						}
						else if (comNum==1){
							System.out.println("???????.");
							break;
						}
						else {
							System.out.println("???????.");
							break;
						}
					case 1:
						if (comNum == 0) {
							System.out.println("???????.");
						
							break;}
						else if (comNum==1){
							System.out.println("???????.");
							break;
						}
						else {
							System.out.println("???????.");
							break;
						}
					case 2:
						if (comNum == 0) {
							System.out.println("???????.");
							break;
						}
						else if (comNum==1){
							System.out.println("???????.");
							break;
						}
						else {
							System.out.println("???????.");
						
							break;}
					}
				}
		}
	}

}
