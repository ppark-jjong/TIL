import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
/* */
/*
 * 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
 * 
 * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
 * 
 * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
 * 즉 하루에 올라가는 높이가 떨어지는 높이보다 작을 수는 없고 A,B,V는 0일 수도 없다
 * 
 * 출력
 * 첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
 */
/* 시간 초과가 중요한 문제이다
 * 만약 for이나 while로 돌릴 경우
 * 반복문이 돌려지는 시간이 문제에서 요구한 시간을 넘어선다
 * 따라서 if문으로 끝낼 수 있는
 * 다시 말해 정해진 시간안에 컴파일 될 수 있는 알고리즘을 짜야된다
*/
import java.util.Scanner;

public class BJ_2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt(); // 하루에 올라갈 수 있는 높이
        int B = sc.nextInt();// 잘 때마다 떨어지는 높이
        int V = sc.nextInt();// 총 올라갈 높이

/* 전체 기간에서 잘떄마다 떨어지는 높이를 뺴주는 이유는
만약 A-B만 하게 되면 정상에 도착했을 때 다시 내려와 정상에 도달하게된다
다시말해 정상에 도착했는데 미끄러져 하루가 더걸려 다시 도착하게 된다는거다
문제에서 중점은 정상 도착 시 미끄러지지 않는다 이기 때문에
이 조건을 만족하기 위해서는 전체에서 미끄러지는 거리를 뺴
실제로 도달하는 날을 재야 된다*/        
        int day = (V - B) / (A - B);

        // 나머지가 있을 경우 즉 다시 올라가야할 칸이 하루에 올라갈 칸보다 작을 경우 그냥 +1만 해주면 된다
        if ((V - B) % (A - B) != 0) {
            day++;
        }
        System.out.println(day);
    }
}


/* 근데 위 Scanner 읜 100m/s를 초과하는 시간대를 가져서 무조건 실패가 뜬다
따라서 해당 buffer를 써야 한다
 * import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
 
		int day = (length - down) / (up - down);
		if ((length - down) % (up - down) != 0)
			day++;
 
		System.out.println(day);
	}
}
 */