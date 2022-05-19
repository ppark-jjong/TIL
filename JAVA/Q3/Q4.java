package Homework;

import java.util.Random;
import java.util.Scanner;

public class Q4 {
	public int computer() {
		Random r = new Random();
		int c = r.nextInt(3);
		
		switch(c) {
		case 0:
			System.out.println("컴퓨터 : 가위");
			break;
		case 1:
			System.out.println(("컴퓨터 : 바위"));
			break;
		case 2:
			System.out.println("컴퓨터 : 보");
			break;
		}
		return c;
	}
	
	
	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		Q4 cal = new Q4();
			while(true) {
				System.out.print("가위(0), 바위(1), 보(2), 종료(-1) 중 정수 하나를 적으시오 >>");
				int myNum = ex.nextInt();
				int comNum = cal.computer();
				if(myNum>2&&myNum<-1) {
					System.out.println("잘못 입력하셨습니다.");
				}
				else {
					switch(myNum) {
					case 0:
						if (comNum == 0) {
							System.out.println("비겼습니다.");
						break;
						}
						else if (comNum==1){
							System.out.println("졌습니다.");
							break;
						}
						else {
							System.out.println("이겼습니다.");
							break;
						}
					case 1:
						if (comNum == 0) {
							System.out.println("이겼습니다.");
						
							break;}
						else if (comNum==1){
							System.out.println("비겼습니다.");
							break;
						}
						else {
							System.out.println("졌습니다.");
							break;
						}
					case 2:
						if (comNum == 0) {
							System.out.println("졌습니다.");
							break;
						}
						else if (comNum==1){
							System.out.println("이겼습니다.");
							break;
						}
						else {
							System.out.println("비겼습니다.");
						
							break;}
					}
				}
		}
	}

}
