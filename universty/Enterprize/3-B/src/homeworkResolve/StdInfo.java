package homeworkResolve;

import java.util.Scanner;
//DTO 역할을 함
public class StdInfo {
	private String stdName;
	private String stdNum;
	
	Scanner in = new Scanner(System.in);


	public String getStdName() {
		return stdName;
	}

	public String getStdNum() {
		return stdNum;
	}

	//init 메서드로 지정한 메서드
	public void inputInfo() {
		System.out.println("학생 이름 입력 : ");
		stdName = in.nextLine();
		System.out.println("학생 학번 입력 : ");
		stdNum = in.nextLine();
	}
}
