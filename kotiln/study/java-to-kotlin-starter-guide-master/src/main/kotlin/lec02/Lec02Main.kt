import java.lang.IllegalArgumentException

fun main() {


    //null을 완전히 다른 타입으로 취급한다고 했는데, null 취급으로 선언된 변수들은 내부함수호출도 다르게 호출한다.
    //그 종류로는 Safe Call 과 Elvis 연산자가 있다
    //Safe Call 함수 null이 아니면 뒤에껄 실행하고 (메서드) null이면 전체가 null 이다
    val str: String? = null
    str.length //불가능
    str?.length // 가능 -> null이 아니면 그대로 실행 / null 이면 null 취급을 한다 (출력값 = null)

    //Elvis 연산자 앞에 메서드 결과가 null이면 : 뒤에 값을 사용 해라
    str?.length ?: 0 // Safe Call 후의 값들을 조정 가능 (약간 예외처리 느낌) (출력값 = 0)
}

fun startWithA1(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("null이 들어왔습니다")
}

fun startWithA2(str: String?): Boolean? {
//    if (str == null) {
//        return null
//    }
//    return str.startsWith("A")

    return str?.startsWith("A")
}

fun startWithA3(str: String?): Boolean {
//    if (str == null) {
//        return false
//    }
//    return str.startsWith("A")
    return str?.startsWith("A") ?: false
}

//만약 절대로 Null 이 될 수 없을 때 NotNUll 일 때
fun startWithA4(str: String?): Boolean {
    return str!!.startsWith("A")
}

//플랫폼 타입
/* 코틀린이 Null 관련 정보를 알 수 없는 타입
* Runtime 시 Exception이 날 수 있다.*
왜냐면 코틀린에서는 일단 실행시키고 오류를 잡기 때문에
만약 자바 라이브러리를 쓸 경우 단일지점 랲핑을 통해 오류 처리를 해주는 것이 TIP
 */

//Lec 02 정리
/*
- 코틀린에서 null이 들어갈 수 있는 타입은 완전히 다르게 간주된다
    - 한 번 null 검사를 하면 non-null임을 컴파일러가 알 수 있다
- null 이 아닌 경우 호출되는 Safe call인 ?. 가 있다.
- null인 경우에만 호출되는 Elvis 연산자 ?: 가 있다.
- null이 절대 아닐 때 사용할 수 있는 널 아님 단언 !! 가 있다.
- 코틀린에서 java코드를 사용할 때 플랫폼 타입 사용에 유의 해야한다
    - java 코드를 읽으며 null 가능성 확인 / 코틀린에서 wrapping 처리 해야함
    */
