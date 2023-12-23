import java.io.BufferedReader
import java.io.File
import java.io.FileReader

// try catch finally 구문
fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt() //기본타입 형변환은 toType() 을 사용한다
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str}는 숫자가 아닙니다") //new 연산자를 사용하지 않고 예외처리함
    }//포맷팅이 간결하다 try catch 문법은 동일하고 구문은 간결하다
}
// try catch finally 구문2
fun parseIntOrThrow2(str: String): Int {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

//Checked Exception과 Unchecked Exception
class FilePrinter {
    //File 객체를 쓰게되면 자바에서 throws IOException을 무조건 선언하여 상속받은 객체를 동일하게 예외처리를 해야하는데 코틀린은 안해도됨
    // 다시말해 자바는 Checked Exception 이라고 하여 무조건 예외를 짚고 넘어가야하는 특징인 반면
    // 코틀린은 Unchecked Exception으로 딱히 필요없음ㄴ
    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        var reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }
}

//try with resources
//코틀린에서는 try with resources 구문이 사라지고 use라는 구문을 사용한다
class FilePrinter2 {
    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use{reader -> println(reader.readLine())}
    }
}

/*Lec07 정리
try catch finally 구문은 문법적으로 완전히 동일하다
    try catch가 expression으로 취급하기 때문에 바로 활용가능
코틀린에서 모든 예외는 Unchecked Exceptiondlek
코틀린에서 try with resources 구문이 없다 대신 코틀린의 언어적 특징을 활용하여 close 구문을 호출한다*/