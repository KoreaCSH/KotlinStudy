package ch4

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