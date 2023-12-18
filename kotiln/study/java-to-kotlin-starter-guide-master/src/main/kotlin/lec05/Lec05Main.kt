import java.lang.IllegalArgumentException

//Kotlin에서의 if문
fun validateScoreIsNotNegative(score: Int) { //함수 리턴타입인 Unit(void)가 생략됨
    if (score < 0) {
        //exception을 던질 때 new를 생략
        throw IllegalArgumentException("${score}는 0보다 작을 수는 없다")
    }
    if (score !in 0..100) {

    }
}

//Expresison & Statement
/* Expresison : 하나의 값으로도 도출 되는 문장
   Statement : 프로그램 문장, 하나의 값으로 도출 되지 않는다 (상위 개념
   java에서는 if 문을 statement 취급을 한다 ( = 이거로 바로 할당이 될 수 없다는 것이다)
   이를 보완하기 위해 삼항연산자를 사용한다
   kotlin에서는 if 문을 expresison 취급을 한다 ( = 를 사용하거나 바로 return을 할 수 있다)
   따라서 kotlin에서는 삼항 연산자를 사용하지 않는다
   * */
fun getGrade(score: Int): String { //이런 식으로 if else 문을 바로 함수 return 으로 선언 가능하다
    return if (score >= 90) {
        return "A"
    } else if (score >= 80) {
        return "B"
    } else if (score >= 70) {
        return "C"
    } else {
        return "D"
    }
}

fun validateIn(score: Int) {
    if (score in 0..100) {
        //자바에서는  if( 0 <= score && score <= 100) 으로 표현한다
    }
}

//switch 와 when (kotlin에서는 when으로 쓴다)
//v1
fun getGradeWithSwitch(score: Int): String {
    return when (score / 10) { //switch(score/10)
        9 -> "A" //case:9 return "A";
        8 -> "B"
        7 -> "C"
        else -> "D" //default : return "D";
    }
}

//v2 in .. 함수 사용 시
fun getGradeWithSwitch2(score: Int): String {
    return when (score) { //switch(score/10) => 특정한 값으로 칠수도 있다.
        in 90..99 -> "A" //case:9 return "A";
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D" //default : return "D";
    }
}

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        //obj가 String 이라면 해당 함수를 수행하고
        is String -> obj.startsWith("A")
        //아니라면 false를 처리해라
        else -> false
    }
}

fun judgeNumber(number: Int) {
    when (number) {
        1, 0, -1 -> println("어디서 많이 본 숫자입니다")
        else -> println("1, 0, -1 이 아닙니다")
    }
}

//java 코드
/* public void judgeNumber(int number){
* if (number==1 || number == 0 || number == -1){
* sysout("어디서 많이 본 숫자입니다");
* }else
*   sysout("1, 0, -1 이 아닙니다");}}*/

fun judgeNumber2(number: Int) {
    when { //ealry return 처럼 사용할 수 있다 when에 값이 있으면 if 처럼 괄호 값을 따지고 그렇지 않으면 밑에 있는 코드 조건들을 바로 따른다
        number == 0 -> println("주어진 숫자는 0입니다")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수입니다")
    }
}