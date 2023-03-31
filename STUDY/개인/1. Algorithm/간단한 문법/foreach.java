
public class foreach {
    public static void main(String[] args) {

        String[] numbers = { "one", "two", "three" };
        //for 문
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);

        }


        //for each 문
        for (String number : numbers) {
            System.out.println(number);
        }
    }
}
