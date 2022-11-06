/**
 * BJ_1152
 * 문자열이 몇개로 나누어져있는지 구하는 문제
 * 같은 문자열이라도 갯수를 셈
 * 문자열 길이는 1,000,000을 넘지 않는다
 * 공백이 두번 연속 불가능
 * 문자열은 공백으로 시작하거나 끝날 수 있다.
 */
/* Stringtoknizer로 쪼개서 앞뒤 공백 제거 후 세기
 * 조건문으로 공백을 마주치면 카운트 1 올라가기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class BJ_1152 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader 선언
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		System.out.print(st.countTokens());
	}
}