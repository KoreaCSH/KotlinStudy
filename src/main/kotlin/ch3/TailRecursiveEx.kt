package ch3

fun main() {
    val intArray = intArrayOf(1, 2, 3, 4, 5, 6)
    println("index of 3 : ${binarySearch(3, intArray)}")
}

// '꼬리 재귀 함수' 인 경우, tailrec 을 붙이면 컴파일러가 재귀 함수를 비재귀적인 코드로 자동 변환해준다.
// 이를 통해 재귀함수의 간결함과 비재귀 루프의 성능이라는 두 장점을 모두 취할 수 있다.
// 단, 꼬리 재귀가 아니라면 일반적인 재귀 함수로 컴파일된다.
tailrec fun binarySearch(x: Int, array: IntArray, from: Int = 0, to: Int = array.size): Int {
    if(from == to) return -1

    val midIndex = (from + to - 1) / 2
    val mid = array[midIndex]
    return when {
        x > mid -> binarySearch(x, array, midIndex + 1, to)
        x < mid -> binarySearch(x, array, from, midIndex)
        else -> midIndex
    }
}