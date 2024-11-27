package ch4

fun main() {
    val person = PersonSC("John", "Doe")
    val person2 = PersonSC("SeungHeon Choi")

    person.introduce()
    person2.introduce()

    // 생성자 위임 예시
    val person3 = PersonSCV2("John", "Doe")
    person3.introduce()
}