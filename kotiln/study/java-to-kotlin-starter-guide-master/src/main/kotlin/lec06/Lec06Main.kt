//for each 문

fun main() {
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {// 자바에서는 number : numbers 임
        println(number)
    }
}

fun forEach2() {
    for (i in 1..3) { // for (int i=1 ; i<=3 ; i++)
        println(i)
    }
}

fun forEach3() {
    for (i in 3 downTo 1) { //for (int i=3 ; i>=1 ; i--)
        println(i)
    }
}

fun forEach4() {
    for (i in 1..5 step 2) {
        println(i)
    }
}

/*Progression과 Range
1..3 은 등차수열 클래스인 IntProgression을 상속받고 있다 따라서 하단 부분에서 코틀린의 함수값들을 설명하자면
1..3 : 시작값 1 끝값 3 공차 1 인 등차수열
3 downTo 1 : 시작값 3 끝값 1 공차가 -1 인 등차수열
1..5 step 2 : 시작값 1, 끝값 5 공차가 2인 등차수열이다. => 1..5 함수호출 + 등차수열.step(2) 라는 함수가 동시에 호출된 뜻
어쨋든 해당 띄어쓰기로 이루어진 함수들도 함수로 취급한다
변수.함수이름(argument) 대신 => 변수 함수이름 argument 로도 이루어질 수 있다는 뜻이다
그래서 Kotlin에서 전통적인 for 문은 등차수열을 이용한다*/

//while 문 자바와 동일
var i = 1
while (i<=3) {
    println(i)
    i++
}


/*정리
for each 문에서 Java는 : Kotlin은 in을 사용한다
전통전인 for문에서는 Kotlin은 등차수열 in을 사용한다
그 외의 for문 문법은 모두 동일하다*/
