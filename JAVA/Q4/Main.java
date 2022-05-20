package day2;
//근삿값 게임 실행부
public class Main {
	public static void main(String[] args) {
		FindApproximateValue F = new FindApproximateValue();
		System.out.println("근삿값 찾기 게임");
		
		while(true){
			F.loseWinOut(F.gameAct());
			if(F.outGame()) {
				break;
			}
		}
	}

}
