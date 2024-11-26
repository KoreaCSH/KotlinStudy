package ch4

fun main() {
    val person = Person()

    person.firstName = "John"
    person.familyName = "Doe"
    person.age = 25

    person.showMe()

    val room = Room(PersonV5("John"), PersonV5("John", "Doe"), PersonV5("CSH"))
    room.showNames()
}