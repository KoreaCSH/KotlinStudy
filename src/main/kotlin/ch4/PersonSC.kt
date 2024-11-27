package ch4

import java.lang.IllegalArgumentException

// Secondary Constructor (부 생성자) 예제
class PersonSC {
    val firstName: String
    val familyName: String

    constructor(firstName: String, familyName: String) {
        this.firstName = firstName
        this.familyName = familyName
    }

    constructor(fullName: String) {
        val names = fullName.split(" ")
        if(names.size != 2) {
            throw IllegalArgumentException()
        }
        firstName = names[0]
        familyName = names[1]
    }

    fun introduce() {
        println("Hello, I'm $firstName $familyName")
    }
}

// 생성자 위임 호출
class PersonSCV2 {
    val fullName: String

    constructor(firstName: String, familyName: String): this("$firstName $familyName")

    constructor(fullName: String) {
        this.fullName = fullName
    }

    fun introduce() {
        println("Hello, I'm $fullName")
    }
}

// 생성자 위임 호출 V2
class PersonSCV3(val fullName: String) {
    // 기본 생성자로의 위임
    constructor(firstName: String, familyName: String): this("$firstName $familyName")
}