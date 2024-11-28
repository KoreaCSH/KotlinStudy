package ch4

class PersonVS(private val firstName: String, private val familyName: String) {
    fun fullName() = "$firstName $familyName"
}

// 주 생성자를 private 로 만들려면 반드시 constructor 키워드를 사용해야 한다.
class Empty private constructor() {
    fun showMe() = println("Empty")
}

fun main() {
    val p1 = PersonVS("John", "Smith")
    // private 이므로 접근 불가
    // println(p1.firstName)

    println(p1.fullName())

    // 주 생성자가 private 이므로 접근불가
    // Empty().showMe()
}