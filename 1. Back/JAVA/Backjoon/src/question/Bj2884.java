package question;
import java.util.Scanner;

public class Bj2884 {
	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		
		int H = ex.nextInt();
		int M = ex.nextInt();
		
		int result=M-45;
		
		if(H<24&&H>-1) {	
			if(M>59) {
				System.out.println("분을 잘못입력하셨습니다");
			}else {
				if(result<0) {
					result = Math.abs(result);
					result = 60-result;
					H--;
					if(H<0) {
						H=23;
					}
				}
			}
		}
		System.out.println(H + " "+ result);
		
	}

}
