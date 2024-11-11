package ch2.operation

import java.util.*

fun main() {
    // Java 와 같이 String 은 불변
    print("name: ")
    val name = readln()
    println("Hello, $name!\nToday is ${Date()}")

    // raw string
    val message = """
        Hello, $name!
        Today is ${Date()}.
        This is triple quote: '${"\"\"\""}'
    """.trimIndent()
    println(message)

    // 모든 String 인스턴스는 length, lastIndex 프로퍼티가 제공된다.
    val s = "Hello"
    val length = s.length
    println("length : $length")

    val lastIndex = s.lastIndex
    println("lastIndex : $lastIndex")

    // [] 각괄호로 String 의 개별 문자에 접근 가능하다.
    println(s[0])
    println(s[lastIndex])

    // Java 는 == 와 != 이 '참조 동등성'을 비교하기에 String 을 비교할 때 equals 메서드를 사용해야 하는 반면,
    // Kotlin 은 == 가 기본적으로 equals 메서드를 가리키는 편의 문법이다.
    // Kotlin 에서 참조 동등성 비교는 '===' 와 '!==' 연산자를 사용한다.
    val s2 = "Hello"
    val s3 = "He" + "llo"
    println(s2 == s3)
}