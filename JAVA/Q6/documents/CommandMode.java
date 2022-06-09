package documents;
import java.util.Scanner;

public class CommandMode {
	Scanner ex = new Scanner(System.in);
	Command d = new Command();
	public void setMode() {
		
	}
	
	public void defaultCommand() {
		String a = ex.next();
		while(true) {
				System.out.print("1~5 중 하나를 선택하시오 >> ");
				if(a.equals(5)) {
						System.out.println("프로그램을 종료합니다.");
						break;
					}
					else {
						d.commandAct(a);
					}
				}
					
	}
	}
		
}
