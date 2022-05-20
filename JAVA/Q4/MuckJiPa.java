package day2;

public class MuckJiPa extends RockPaperScissors {
	 public boolean gameAct() {
	        boolean atkDf = super.gameAct();//부모클래스의 가위바위보 메서드 묵지빠는 가위바위보에서 이긴사람이 공격권을 가지기 때문에
	        boolean losewin = true; //누가 이겼는지 배출하는 불련형 값

	        while (true) {
	            if (atkDf) {//유저가 이겼을때
	                System.out.println("\n[공격을 준비하세요]");
	                
	                String user = userSelect();
	                String computer = computerSelect();

	                System.out.println("유저[공격] : " + user);
	                System.out.println("컴퓨터[방어] : " + computer);

	                int a = muckJjiPaAct(user, computer);//묵지빠를 했을 때 누가 이겼는지 판가름하는 메서드

	                if (a == 1) {
	                	System.out.println("유저가 이겼습니다.");
	                    break;
	                }
	                else if (a == 2) {
	                    System.out.println("\n[공수 교대]");
	                    atkDf = false;//유저가 졌을 때로 바꿔줘야 공수가 교대 된 상태의 else 문을 사용할 수 있다.
	                }
	            }
	            else {//유저가 졌을 때
	                System.out.println("\n[방어를 준비하세요]");
	                
	                String user = userSelect();
	                String computer = computerSelect();

	                System.out.println("\n유저[방어] : " + user);
	                System.out.println("컴퓨터[공격] : " + computer);

	                int a = muckJjiPaAct(computer, user);

	                if (a == 1) {
	                    losewin = false;
	                    break;
	                }
	                else if (a == 2) {
	                    System.out.println("\n[공수 교대]");
	                    atkDf = true;
	                }
	            }
	        }

	        return losewin;
	    }

	    public int muckJjiPaAct(String atk, String df){//
	        int distinction = 0; 

	        if (atk.equals(df))//공격자가 묵찌바를 이겼을 때
	            distinction = 1;
	        else if (isChange(atk, df)) {//공격자와 수비자가 다른 걸 내면 공수가 교대된다. 즉 else if 문이 트루 일때 실행된다
	            distinction = 2;
	        }

	        return distinction;
	    }

	    public boolean isChange(String atk, String df){//공수교대가 되는 기준의 메서드
	        boolean change = false;

	        switch (atk) {
	            case "가위":
	                if (df.equals("바위"))
	                    change = true;
	                break;
	            case "바위":
	                if (df.equals("보"))
	                    change = true;
	                break;
	            case "보":
	                if (df.equals("가위"))
	                    change = true;
	                break;
	        }

	        return change;
	    }
}
