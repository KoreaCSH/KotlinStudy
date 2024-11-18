package ch3

fun main() {
    println(hexDigit(11))
    println(numberDescription(10))
    println(readHexDigit())
}

fun hexDigit(n: Int): Char {
    val hex = when {
        n in 0..9 -> '0' + n
        n in 10..15 -> 'A' + n - 10
        else -> '?'
    }

    return hex
}

// 조건이 어떤 값에 대한 동등성이나 in 연산만 수행하는 경우
// 아래처럼 작성하려면 반드시 else 가 있어야 한다.
fun numberDescription(n: Int, max: Int = 100): String = when(n) {
    0 -> "Zero"
    1, 2, 3 -> "Small"
    in 4..9 -> "Medium"
    in 10..max -> "Large"
    !in Int.MIN_VALUE until 0 -> "Negative"
    else -> "Huge"
}

// 식의 대상(n)을 변수에 연결할 수 있다.
// 하지만, 변수는 when 블록 내부에서만 사용할 수 있고 var 로는 선언할 수 없다.
// Java 의 switch 에는 정수, 이넘, 문자열 등에 대해서만 사용할 수 있지만, 코틀린에서는 범위 검사뿐만 아니라 반드시 Boolean 일 필요도 없다.
fun readHexDigit(): Char = when(val n = readln().toInt()) {
    in 0..9 -> '0' + n
    in 10..15 -> 'A' + n - 10
    else -> '?'
}