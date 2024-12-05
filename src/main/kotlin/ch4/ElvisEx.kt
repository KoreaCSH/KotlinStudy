package ch4

fun main() {
    sayHello("Elvis")
    sayHello(null)

    println(PersonElvisEx(Name("John", "Doe")).describe())
    println(PersonElvisEx(Name("John", null)).describe())
    println(PersonElvisEx(null).describe())
}

// Elvis 연산자를 사용하여 null 을 대신할 default 값을 설정할 수 있다.
fun sayHello(name: String?) {
    println("Hello " + (name?: "John"))
}

class Name(val firstName: String, val lastName: String?)

// Elvis 연산자 오른쪽에 return, throw 넣을 수 있다.
class PersonElvisEx(private val name: Name?) {
    fun describe(): String {
        val currentName = name ?: return "Unknown"
        return "${currentName.firstName} ${currentName.lastName ?: ""}"
    }
}