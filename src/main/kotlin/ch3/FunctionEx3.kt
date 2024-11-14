package ch3

fun main() {
    printSorted(6, 1, 3, 7)
    // 또한, 스프레드 연산자 (*) 를 사용하여 배열을 가변 인자 대신 넘길 수 있다.
    val intArray = intArrayOf(5, 2, 7, 10)
    printSorted(*intArray)

    // FunctionEx2 에 정의된 최상위 함수 readInt() 를 사용할 수 있다.
    val i = readInt()

    // 지역함수
    // 함수 내부에 지역 함수를 정의할 수 있으며, 이 함수의 영역은 함수를 감싸는 블록으로 한정한다.
    // 자신을 둘러싼 함수, 블록에 선언된 변수나 함수에 접근 가능하다. 단, 지역함수에는 가시성 변경자 (private, internal) 를 붙일 수 없다.
    fun printInt(i: Int) {
        println(i)
    }

    printInt(i)
}

// vararg 변경자를 붙여 Java 의 ... 처럼 사용 가능하다. 함수 내부에서 items 는 IntArray 이다.
fun printSorted(vararg items: Int) {
    items.sort()
    println(items.contentToString())
}

// 함수 영역과 가시성
// 1. 파일에 직접 선언된 최상위 함수는 공개(public) 함수이므로 프로젝트 어디에서나 쓰일 수 있다.

// 2. 최상위 함수를 private 로 선언하면 정의된 파일 안에서만 사용 가능하다.
// internal 이라는 변경자로도 가능하며, 이는 함수가 적용된 모듈 내(함께 컴파일 되는 범위)에서만 함수를 사용할 수 있도록 제한하는 것이다.
private fun privateFunction() {
    println("private Function")
}
