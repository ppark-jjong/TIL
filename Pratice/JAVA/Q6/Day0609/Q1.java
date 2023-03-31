package Day0609;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;
//TreeSet과 Random을 이용하여 랜덤의 숫자 10개를 정렬하여 출력하라
public class Q1 {
	public static void main(String[] args) {
		Random r = new Random();
		TreeSet<Integer> num = new TreeSet<>();//treeset은 정렬과 동시에 set의 조건인 중복 원소 없음을 가진다 
		for(int i =0; i<10; i++) {
			 int a = r.nextInt(99+1);//기본 클래스 중 random클래스 
			 num.add(a);
		}
		Iterator<Integer> i = num.iterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		
	}

}
