package Day0609;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner ex = new Scanner(System.in);
		Map<String, Integer> list = Map.of("사과", 5000, "바나나", 2000, "포도", 3000, "딸기", 4000, "멜론", 6000);
		System.out.println("과일의 종류 \n사과, 바나나, 포도, 딸기, 멜론");
		System.out.print("과일을 하나 고르시오 >>");
		String key = ex.next();
		System.out.println();
		if(list.containsKey(key)) {
			System.out.println(key + "의 가격은" + list.get(key) + "원 입니다.");
		}
		else
			System.out.println("찾으시는 과일이 없습니다.");
		System.out.println("---------------------------------------");
	 HashMap<String, Integer> fruits = new HashMap<>();
	 System.out.println("과일의 이름과 가격을 차례대로 입력하시오 (5개)");
	 for(int i =0; i<6; i++){
		 String keys = ex.next();
		 int sets = ex.nextInt();
		 fruits.put(keys, sets);
		 System.out.println("해당 과일이 저장되었습니다.");
	 }
	 System.out.print("찾으실 과일을 입력하시오 >>");
	 String fruit = ex.next();
	 if(fruits.keySet().contains(fruit)) {
		 System.out.println(fruit + "의 가격은 " + fruits.get(fruit) + "원 입니다.");
	 }
	 else
		 System.out.println("찾으시는 과일이 없습니다.");
	 
	 /*
	  HashMap map = new HashMap<>();
	  map.putAll(Map.of("사과", 1000 ......);
	  
	  */
		
		
		
		
	}
	

}
