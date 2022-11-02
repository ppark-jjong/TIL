import java.util.Scanner;

public class BJ_4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Testcase = sc.nextInt(); // 테스트케이스의 수

		double score[] = new double[Testcase];		
		for (int i = 0; i < Testcase; i++) {
			int Student = sc.nextInt();// 평균구할 갯수
			int count = 0; //평균을 넘는 학생의 수 리셋
			int sum = 0; //전체 점수 리셋

			for (int j = 0; j < Student; j++) {
				score[j] = sc.nextInt(); // 점수 주입
				sum += score[j];

			}
			double result = sum / Student;// 평균값
		
			for (int t = 0; t < Student; t++) {
				 //평균 넘는 학생수 학생 수 세기
				if (result < score[t]) {
					count++;
				}
			}
			
				System.out.println(100*(count/Student)); //학생 비율 
			
			}

		sc.close();
	}

}
