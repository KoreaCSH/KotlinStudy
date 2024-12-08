package ch4

import java.lang.IllegalArgumentException
import java.util.*

fun main() {
    val s1 = Student("John Doe", 26)
    // s1.name 은 사실 getName 으로 접근하고 있는 것
    println("name : ${s1.name}")

    // 커스텀 setter
    try {
        s1.age = 20
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    // 커스텀 getter 에 접근
    println("age : ${s1.age}")
    println("lastChanged : ${s1.lastChanged}")
}

// 코틀린은 val 프로퍼티에 대해서는 getter 를,
// var 프로퍼티에 대해서는 getter, setter 를 제공한다.
// 또한, 아래처럼 커스텀 getter, setter 를 설정할 수도 있다.
class Student(val name: String, age: Int) {
    var age = age
        get(): Int {
            println("Accessing age")
            // 직접 뒷받침하는 필드인 field
            // field 에 프로퍼티의 실제 값이 저장된다.
            // field 를 사용하는 이유는 getter, setter 의 무한 재귀 호출을 방지하기 위함이다.
            return field
        }
        set(value) {
            if (value < 0) {
                throw IllegalArgumentException("Invalid age : $value")
            }
            // age = value 코드는 실제로 setter 를 호출하는 것이므로
            // setter 를 무한으로 호출한다.
            // 그렇기 때문에 field (Backing Field) 에 값을 저장해야 한다.
            lastChanged = Date()
            field = value
        }

    // setter 에 가시성 변경자를 붙일 수도 있다.
    var lastChanged: Date? = null
        private set

    fun introduce() {
        println("$name, $age")
    }
}