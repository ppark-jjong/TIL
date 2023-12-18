import com.lannstark.lec01.Person

fun main() {


    //기본 타입
    // Java에서는 기본 타입간의 변환은 암시적으로 이루어 진다    ex ) Float <=> Double
    // Kotlin에서는 기본 타입 간의 변환은 명시적으로 이루어 진다.
    val number1 = 3
    val number2: Long = number1.toLong() //명시적인 메서드가 필요하다

    //기본타입 활용 중 Nullable 일 경우
    val number3: Int? = 3
    val number4: Long? = number3?.toLong() ?: 0L
}

//타입 캐스팅
/*
    value is Type ==> value의 Type이 true == true / value의 Type이 false == false
    value !is Type ==>  value의 Type이 false == true /  value의 Type이 true == false
    value as Type ==>  value의 Type이 true == Type 으로 캐스팅

* */
fun printAgeIfPerson(obj: Any) {
    //obj가 person 객체라면 true 아니면 false == java의 instanceof
    if (obj is Person) { //is 라는 함수는 자바의 instanceof 와 쓰임새가 같다
        // obj를 person타입으로 간주한다  == java의 (Person) => 생략 될 수 있음
        // 왜냐 코틀린의 컴파일 추론이 있기 떄문(스마트 캐스트라고함)
        val person = obj as Person //as 라는 함수는 자바의 (Person) obj와 같은 쓰임새다
        println(obj.age) //이렇게 바로해도 인식한다. (스마트 캐스트)
    }
    //obj가 person이 아니라면
    if (obj !is Person) {
        //이라고 쓸 수 있다.
    }
}


//as함수에 대해
fun printAgeIfPersonNullable(obj: Any?) {
    val person2 = obj as? Person //obj가 null이 아니라면 Person 타입으로 변화시키고 / null 이라면 Safe Call 처럼 이 전체가 null이 된다.
    println(person2?.age) //nullable인 ? Safe Call을 써야한다.
}

//Kotlin의 타입 3가지 (Any, Unit, Nothing)
/*1. Any
* java의 object 타입과 같이 모든 객체의 최상위 타입이다.
* 모든 Primitive Type의 최상의 타입도 Any 이다
* Any 자체로는 null을 포함할 수 없어 nullable 함수인 Any?를 사용해야한다.
* Any 에 equals / hashCode / toString이 존재한다.*/
/*2. Unit
* Unit은 Java의 void와 동일한 역할을 수행한다
* void 와 다르게 Unit 은 그 자체로 타입 인자로 사용가능하다 => 바로 제네릭을 호출하여 수행가능하다
* 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미 => 코틀린의 Unit은 실제 존재하는 타입이라는 것을 표현*/
/*3. Nothing
* Nothing은 함수가 정상적으로 끝나지 않았다는 것을 표현하기 위해 사용한다
* 무조건 예외를 반환하는 함수 / 무한루프 함수 등*/

/*String interpolation 함수
* String을 변환할 때 자바에서는 String.format()을 사용한다
* 코틀린에서는 ${변수}로 String format을 할 수 있다
* ex) val log = "사람 이름을 ${person.name}이고 나이는 ${person.age}세 입니다."   <- 권장한다
* ex) val name = "박종혁"    println("이름 : $name") 도 가능하다
* <TIP> 보통 객체.변수 이렇게 사용하는걸 권장한다*/

val name = "박종혁"
// String indexing 함수
val withoutIndent =
    """
       ABC
       123
       456
       ${name}
       """.trimIndent()
println(withoutIndent)// 이렇게 할시 출력값은 ABC123456박종혁 이 나온다.


/*Lec 03 정리
* 코틀린의 변수는 */




