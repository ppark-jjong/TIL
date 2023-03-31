
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors implements IGameFrame {

	@Override
	public <T> T computerSelect() {//<T> 타입을 쓰는 메서드이고 T를리턴한다.
		Random r = new Random();// 랜덤의 수 r변수에 할당
		int n = r.nextInt(2); // n에 0~2개의 범위내에서 숫자 할당
		T select = (T) ""; //T타입의 select 변수이다. 
		
		switch(n) {
		case 0:
			select = (T) "가위";
			break;
		case 1:
			select = (T) "바위";
			break;
		case 2:
			select = (T) "보";
			break;
		}
		return select;
	}
	

	@Override
	public <T> T userSelect() {
		String s = "";
		while(true) {
			Scanner ex = new Scanner(System.in);
			System.out.print("가위 바위 보 중 하나만 입력하시오 >>");	
			s = ex.next();
			if(s.equals("가위")||s.equals("바위")||s.equals("보")) {
				 break;
			}
			else
				System.out.println("다시 입력하시오");					
		}
		return (T) s;
	}

	@Override
	public boolean gameAct() {
		
		boolean result = true;//유저가 이긴게 트루
		while(true) {
			String user = userSelect(); //T타입인 userSelect에 T를 선언해야하는데 지정을 안해도 자동 형변환이 이루어진다 책에 있음
			String com = computerSelect();
			if(user.equals(com)) {
				System.out.println("비겼습니다.");
			}
			else{
				if(user.equals("가위")&&com.equals("바위")) {
						result = false;
				}
				else 
					break;
							
				if(user.equals("바위")&&com.equals("보")) {
					result = false;
					}
				else 
					break;
				
				if(user.equals("보")&&com.equals("가위")) {
						result = false;
				}
				else
					break;
				}
			}
		return result;
	}



}
