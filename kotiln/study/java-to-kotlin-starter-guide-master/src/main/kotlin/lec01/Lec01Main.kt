
fun main() {
    //데이터 타입은 따로 명시 하지 않음 (정적 언어로 컴파일 시 자동 추론)
    //하지만 데이터 타입을 원한다면 선언 할 수 있음
    var number1 = 10L //var number1: Long = 10L

    val number2 = 10L //val number2: Long = 10L

    //만약 변수 선언 후 따로 값을 지정해주지 않는 경우 컴파일러가 데이터 타입 추론이 불가능 하므로 따로 데이터 타입을 명시 해주어야 함
    var number11: Long

    //val 일 경우에도 컬렉션(ArrayList)에 값을 추가 할 수 있다
    // tip : 클린코드를 위해서는 먼저 val로 선언 후 필요에 따라 var로 교체하는 방향 추천


    //Kotlin에서의 Primitive Type
    //java에서는 long == primitive Type / Long == reference Type 이지만
    //Kotlin은 따로 구분 하지 않음 컴파일시 내부적으로 자동 분류 해줌 즉 프로그래머가 boxing과 unboxing 고려하지 않아도 됨

    //Kotlin은 null이 들어갈 수 없게 자동 설계 되어 있음 만약 넣고 싶으면 하단의 ? 선언을 따른다
    var number22: Long?
    number22 = null

    val person = Person("최태현")

    //Lec 01 정리
    /*
    - 모든 변수는 var / val 를 붙여주어야 한다.
        var은 변경 가능 / val 변경 불가능
    - 타입을 명시적으로 작성하지 않아도 자동 컴파일 추론 한다.
    - Primitive Type과 Reference Type을 구분하지 않아도 된다.
    - Null이 들어갈 수 있는 변수는 타입 뒤에 ?를 붙여 아예 다른 타입으로 간주한다.
    - 객체 인스턴스화를 할 때 new를 따로 붙이지 않는다.
     */
}