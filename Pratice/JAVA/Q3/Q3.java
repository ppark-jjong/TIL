package Homework;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q3 {

	public static void main(String[] args) {
        Scanner ex = new Scanner(System.in);
        System.out.print("?? : ");
        String s = ex.nextLine();
        StringTokenizer t = new StringTokenizer(s);
        String[] array = new String[t.countTokens()];
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            array[i] = t.nextToken();
        }
        System.out.println("??:" + t.countTokens());
        System.out.print("?? : ");
        for (String string : array) {
            System.out.print(string + ", ");
        }
    }
}





