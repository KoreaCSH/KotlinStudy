package ch4

import util.prefix
import java.io.File

fun main() {
    val name = readln()
    println("$prefix $name")

    val content = Content()
    try {
        // lateinit 프로퍼티는 일반 프로퍼티와 모두 동일하나,
        // 초기화되지 않은 프로퍼티에 접근할 때 UninitializedPropertyAccessException 를 throw 한다는 차이가 있다.
        println(getContentSize(content))
    } catch (e: UninitializedPropertyAccessException) {
        println(e.message)
    }
}

class Content {
    // lateinit 변수는 반드시 var 이어야 한다. (소스의 여러 곳에서 초기화될 수 있으므로)
    // 그리고, 정의하면서 초기화 할 수 없다.
    lateinit var text: String

    fun loadFile(file: File) {
        text = file.readText()
    }

}

// 만약, lateinit 으로 text 를 정의하지 않았다면, ?. , ?: 등의 추가 연산자가 필요했을 것이다.
fun getContentSize(content: Content) = content.text.length