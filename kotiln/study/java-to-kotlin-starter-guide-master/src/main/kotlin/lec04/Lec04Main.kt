import com.lannstark.lec04.JavaMoney

fun main() {
    val money1 = JavaMoney(1000L)
    val money2 = money1
    val money3 = JavaMoney(1000L)
    //코틀린에서 Java 와 다르게 객체를 비교할 때 비교 연산자를 사용하면 자동으로 compareTo를 호출해준다
    if (money1 > money2) { //여기서 미리 생성된 compareTo메서드를 바로 호출 할 수 있음
        println("money1이 money2보다 금액이 큽니다")
    }

    //비교연산자와 동등성, 동일성
    /*동등성 : 두 객체의 값이 같은가? => java에서는 equals / kotlin에서는 == (간접적으로 equals를 호출하는 것)
    * 동일성 : 완전히 동일한 객체인가 (주소값까지 같은가) => java에서는 == / kotlin에서는 === */

    println(money1 === money2)

    //논리 연산자의 Lazy연산들은 java와 동일하게 작동한다
    //논리 연산자와 코틀린에 있는 특이한 연산자
    /* in/ !in 연산
    *  - 컬렉션이나 범위에 포함되어 있다, 포함되어 있지 않다
    *  a..b 연산
    *  - a부터 b까지의 범위 객체를 생성한다. (더 찾아보기)
    *  a[i]
    *  - a에서 특정 Index i 로 값을 가져온다
    *  a[i] = b
    *  - a의 특정 index i에 b를 넣는다*/

    //연산자 오버로딩
    //java에서는 객체를 생성하고 각 객체의 값을 합산해주는 메서드가 따로따로 필요한데 kotlin에서는 자동으로 오버로딩 후 연산해줌
    //kotlin에서는 객체마다 연산자를 직접 정의할 수 있다.
    val result = money1 + money3
}