package day2;
import java.util.Random;
import java.util.Scanner;
//근삿값 게임 구현부
public class FindApproximateValue implements IGameFrame {
	@Override
	public <T> T computerSelect() {
		Random r = new Random();

		Integer bi = new Integer(10);
		return (T) (Integer.valueOf(r.nextInt(99)+1));
 
	}

	@Override
	public <T> T userSelect() {
		Scanner scanner = new Scanner(System.in);
        int num;

        while (true) {
            System.out.println("\n[숫자를 입력하세요 (1 ~ 100)]\n");
            num = scanner.nextInt();

            if (num >= 1 && num <= 100) {
                break;
            }
            else {
                System.out.println("[1부터 100까지의 숫자를 선택해 주세요]");
            }
        }

        return (T) Integer.valueOf(num);	}

	@Override
	public boolean gameAct() {
		boolean result = true;
		Random a = new Random();
		
		while(true) {
			int user = userSelect();//문자형을 인테져 형으로 변환해라
			int com = computerSelect();//문자형을 인테져 형으로 변환해라
			
			int c = a.nextInt(99)+1;//1~100까지의 아무 수나 리턴하는데 그냥 랜덤은 0부터 시작해서 +1을 해준다
			
			int userValue = Math.abs(c-user);//절대값으로 변환
			int comValue = Math.abs(c-com);
			
			if(userValue == comValue)
				System.out.println("비겼습니다.");
			else if(userValue < comValue)
				result = false;
			
			break;
		}
		return result;
	}

}
