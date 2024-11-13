package ch3

fun main() {
    val i = readInt()
    println("i : $i")

    val i2 = readInt(2)
    println("i2 : $i2")

    // 10진수
    val i3 = readIntByUsingDefaultValue()
    println("i3 : $i3")

    val i4 = readIntByUsingDefaultValue(8)
    println("i4 : $i4")

    // 디폴드 파라미터 뒤에 디폴트 값이 정해지지 않은 파라미터가 있는 경우, 해당 함수를 호출할 수 있는 유일한 방법은 '이름 붙은 인자'의 사용 뿐이다.
    // 하지만, 디폴트 값이 있는 파라미터를 함수 인자 목록 뒤쪽에 몰아두는 것이 더 좋은 코딩 스타일이다.
    println(restrictToRange(10, what = 1))

    // 이 경우, 인자가 세 개인(a, b, c) 함수가 덜 구체적인 함수가 되어 첫 번째 함수(a, b) 가 호출된다.
    println(mul(2, 3))
}

// Java 와 마찬가지로 오버로딩 가능
fun readInt(): Int {
    return readln().toInt()
}

fun readInt(radix: Int): Int {
    return readln().toInt(radix)
}

// Kotlin 에서는 default 값을 사용할 수 있기에, 오버로딩을 줄일 수 있다.
fun readIntByUsingDefaultValue(radix: Int = 10): Int {
    return readln().toInt(radix)
}

fun restrictToRange(from: Int = Int.MAX_VALUE, to: Int = Int.MAX_VALUE, what: Int): Int {
    return Math.max(from, Math.min(to, what))
}

fun mul(a: Int, b: Int = 1): Int {
    return a * b
}

fun mul(a: Int, b: Int, c:Int = 2): Int {
    return a * b * c
}