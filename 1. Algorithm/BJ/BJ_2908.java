
import java.util.Scanner;

/**
 * BJ_2908
 */
public class BJ_2908 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // Wrapper 클래스를 이용한 string 변환
        String as = Integer.toString(a);
        String bs = Integer.toString(b);

        // Buffer 클래스로 변환
        StringBuffer asb = new StringBuffer(as);
        StringBuffer bsb = new StringBuffer(bs);

        // Buffer 클래스의 메서드를 이용하여 역순 후 다시 문자열로 변환
        String resulta = asb.reverse().toString();
        String resultb = bsb.reverse().toString();

        // 문자열을 정수형으로 변환 후 값 비교 결과 상수 출력
        int resultai = Integer.parseInt(resulta);
        int resultbi = Integer.parseInt(resultb);

        if (resultai > resultbi) {
            System.out.println(resultai);
        } else {
            System.out.println(resultbi);
        }
    }
}