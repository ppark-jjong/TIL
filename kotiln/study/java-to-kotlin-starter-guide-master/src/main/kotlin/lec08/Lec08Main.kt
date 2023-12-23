//함수 선언 문법 변화
fun max(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

//함수 선언 문법 변화 2
fun max2(a: Int, b: Int): Int { //return을 한번에 묶어 표현식으로 바꿀 수 있다.
    return if (a > b) {
        a
    } else {
        b
    }
}

//함수 선언 문법 변화 3
fun max3(a: Int, b: Int): Int = //표현식으로 바뀐 함수구문은 = 표시로 지칭할 수도 있다.
    if (a > b) {
        a
    } else {
        b
    }

//함수 선언 문법 변화 4
//함수의 데이터 타입은 생략 가능하다 => = 표시를 사용할 때 생략가능하다! (Int 생략)
//만약 {} 인 block 형태를 사용하는 경우 반환타입이 Unit이 아니라면 무조건 명시적으로 데이터 타입을 적어줘야함
//또한 한줄로 교체하여 띄어쓰기로 구분지어 표현 가능하다
fun max4(a: Int, b: Int) = if (a > b) a else b


//함수는 클래스 안에 있을 수도, 파일 최상단에 있을 수 있다. 또한 한 파일 안에 여러함수들이 있을 수도 있다.

//default parameter