package ch4

import java.lang.IllegalArgumentException

class Person {

    var firstName: String = ""
    var familyName: String = ""
    var age: Int = 0

    fun fullName() = "$firstName $familyName"

    fun showMe() {
        println("${fullName()}")
    }

    // 변수처럼 프로퍼티를 사용하는 참조구문
    fun showAge(p: Person) = println(p.age)

    fun readAge(p: Person) {
        p.age = readln().toInt()
    }

    fun setName(firstName: String, familyName: String) {
        this.firstName = firstName
        this.familyName = familyName
    }

}

// 기본 생성자
class PersonV2(firstName: String, familyName: String) {
    val fullName = "$firstName $familyName"

    // 클래스 초기화 시 필요한 로직 수행 가능, return 문은 불가능
    init {
        println("Created new Person instance : $fullName")
    }
}

// 기본 생성자 2
// 프로퍼티가 초기화되지 않으면 (init 블록에서도) 오류 발생 (예외 여부도 확인한다)
class PersonV3(fullName: String) {
    val firstName: String
    val familyName: String

    // init 블록에서 프로퍼티 초기화 가능
    init {
        val names = fullName.split(" ")
        if(names.size != 2) {
            throw IllegalArgumentException("Invalid name : $fullName")
        }

        firstName = names[0]
        familyName = names[1]
    }
}

// 기본 생성자 3
// 기본 생성자 파라미터는 프로퍼티 초기화, init 블록에서만 사용 가능하다.
// 생성자 파라미터 앞에 val, var 키워드 덧붙이면 자동으로 해당 생성자 파라미터 초기화되는 프로퍼티 정의한다.
class PersonV4(val firstName: String, val familyName: String) {
    val fullName = "$firstName $familyName"

    // val 가 없었다면 실행 불가능한 코드이다.
    fun printFirstName() {
        println(firstName)
    }
}

// 기본 생성자 4
// 기본 생성자 파라미터에 default 설정, vararg 도 사용 가능하다.
class PersonV5(val firstName: String, val familyName: String = "") {
    val fullName = "$firstName $familyName"
}

class Room(vararg val people: PersonV5) {
    fun showNames() {
        for (person in people) {
            println(person.fullName)
        }
    }
}

