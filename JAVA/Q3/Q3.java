package Homework;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q3 {

	public static void main(String[] args) {
        Scanner ex = new Scanner(System.in);
        System.out.print("입력 : ");
        String s = ex.nextLine();
        StringTokenizer t = new StringTokenizer(s);
        String[] array = new String[t.countTokens()];
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            array[i] = t.nextToken();
        }
        System.out.println("단어 갯수 : " + t.countTokens());
        System.out.print("정리된 토큰 : ");
        for (String string : array) {
            System.out.print(string + ", ");
        }
    }
}





