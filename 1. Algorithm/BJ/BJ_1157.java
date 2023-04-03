import java.util.Scanner;

public class BJ_1157 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();

        String[] array = a.split("");

        
        // 인덱스마다 생긴 알파벳을 변수로 저장하고 카운트를 올린다 이때 다 소문자로 바꿔야 한다
        // 배열이 끝나면 변수끼리 비교후 조건식 대입 후 결과 출력
        // Map 을 생성해서 배열의 크기만큼 변수가 생성되게한다


        for(int i = 0; i<array.length ; i++){
            String k = String.valueOf(i); // i를 String으로 치환후 k로 재선언
            String k =  array[i];
        }
    }
}