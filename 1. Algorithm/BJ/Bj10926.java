package question;
import java.util.Scanner;
public class Bj10926 {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String name = sc.next();
			
			String name1= name;
			
				if(name.equals(name1)) {
					System.out.println(name + "??!");
				}
				else {
					System.out.println("정상 저장하였습니다.");
				}
	}

}
