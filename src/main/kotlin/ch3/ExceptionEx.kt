package ch3

import java.lang.NumberFormatException

fun main() {
    val i1 = readIntTestingException(5)
    println("i1 = $i1")

    val default = readIntTestingException(5)
    println("default = $default")
}

// Java 의 try - catch 와 거의 일치하며, 단, Kotlin 의 try-catch 블록은 값으로 처리될 수 있는 '식'이다.
fun readIntTestingException(default: Int) = try {
    readln().toInt()
} catch (e: NumberFormatException) {
    println("Exception: $e")
    default
}