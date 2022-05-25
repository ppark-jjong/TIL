import java.util.Scanner;
public interface IGameFrame {
	 public <T> T computerSelect();
	 public <T> T userSelect();

	 public boolean gameAct();
	    
	    default void loseWinOut(boolean loseWin){//이렇게 인터페이스 안에서 지정 할 수도 있음
	        if (loseWin)
	            System.out.println("\n[유저 승리]\n");
	        else
	            System.out.println("\n[컴퓨터 승리]\n");
	    }

	    default boolean outGame() {//디폴트 함수는 이 틀을 사용하는데 이 메서드 영향을 받으면 안되니까 디폴트로 선언한다.
			boolean game = true;
	    	Scanner ex = new Scanner(System.in);
			
	    	while(true) {
		    	System.out.println("게임을 실행하시겠습니까 (실행 : 1 / 종료 : 0");
				int a = ex.nextInt();
				if(a==0) {
					System.out.println("게임을 종료합니다.");
					game = false;
					break;
				}
				else
					break;
				}	
	    	return game;
		}	    
}
