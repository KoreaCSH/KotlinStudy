package ch2

import java.util.*

fun main() {
    // 1. 배열 정의하기
    val a = emptyArray<String>()
    val b = arrayOf("hello", "world") // Array<String>
    val c = arrayOf(1, 4)             // Array<Int>

    val size = readln().toInt()
    val squares = Array(size) {(it + 1) * (it + 1)}
    println(Arrays.toString(squares))

    // Array<Int> 는 정상 작동하지만, 모든 수를 박싱하기 때문에 실용적이진 않다.
    // 그러므로 Kotlin 에서 제공하는 ByteArray, ShortArray, IntArray, LongArray ... 라는 특화된 배열 타입을 활용하자
    // JVM 에서 해당 배열 타입들은 int[], long[] 등의 원시 타입 배열로 표현된다.

    val operations = charArrayOf('+', '-', '*', '/', '%')
    val squaresInt = IntArray(10) {(it + 1) * (it + 1)}
    println(Arrays.toString(squaresInt))

    // Kotlin 에는 new 연산자가 없다. 또한, 배열 원소를 명시적으로 초기화해야 한다는 점이 java 와 다른 점이다.

    // 2. 배열 사용하기
    // String 처럼 size (String 의 length), lastIndex 프로퍼티 존재 및 인덱스 연산으로 원소에 접근 가능
    println(squaresInt.size)
    println(squaresInt.lastIndex)
    println(squaresInt[2])
    println(squaresInt[squaresInt.lastIndex])

    val copySquares = squaresInt.copyOf()
    squaresInt.copyOf(12) // 부족한 부분에는 0이 채워짐

    val arr1 = intArrayOf(1, 2, 3) + 4 // 원소 추가 : 1, 2, 3, 4
    println(Arrays.toString(arr1))

    val arr2 = intArrayOf(1, 2, 3) + intArrayOf(4, 5)
    println(Arrays.toString(arr2))

    // 배열 내용 비교하려면 contentEquals()
    println(intArrayOf(1, 2, 3).contentEquals(intArrayOf(1, 2, 3)))

    // Arrays.toString() -> contentToString() 으로 대체 가능
    val incrementIntArr = IntArray(10) {it + 1}
    println(incrementIntArr.contentToString())
}