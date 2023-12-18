package com.group.libraryapp.domain.book

import javax.persistence.*

@Entity
class Book(
    //val - java에서 final 변수
    //var - java에서 일반 변수
    val name: String, // String name; 과 같음 변수를 선언하고 타입을 명시함

    @Enumerated(EnumType.STRING)
    val type: BookType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    //객체 생성 시 확인 하는 메서드 (생성자 선언 시 출력문 끼우는 느낌)
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다")
        }
    }

    //companion object 클래스 정보 선언과 동시에 인스턴스 생성을 하는 함수 static class? 라고 보면 된다.
    companion object {
        fun fixture(
            name: String = "책 이름",
            type: BookType = BookType.COMPUTER,
            id: Long? = null,
        ): Book {
            return Book(
                name = name,
                type = type,
                id = id,
            )
        }
    }

}