package ch3

import kotlin.math.PI

fun main() {
    print("Enter radius: ")
    val radius = readln().toDouble()
    println("Circle Area: ${circleArea(radius)}")
    println("Circle Area: ${circleArea2(radius)}")

    val intArray = intArrayOf(1, 2, 3)
    println(incrementElement(intArray))
    println(intArray.contentToString())

    val h = readln().toInt()
    val w = readln().toInt()
    // 이름 붙은 인자 방식
    println("rectangle Area : ${rectangleArea(width = w, height = h)}")
}

// 코틀린 함수 파라미터는 무조건 불변. 함수 본문에서 파라미터 변경 시 컴파일 오류 발생
// 또한, 파라미터 앞에 val, var 표시 불가. 무조건 파라미터는 불변 값으로 강제되어 있음.
fun circleArea(radius: Double): Double {
    // Kotlin 에는 PI 라는 표준 상수 존재 (파이의 근삿값 표현)
    return PI * radius * radius
}

// 식이 본문인 함수 - 중괄호 생략 가능
fun circleArea2(radius: Double): Double = PI * radius * radius

// 변수와 달리 파라미터에는 항상 타입을 지정해야 한다
fun incrementElement(intArray: IntArray): Int {
    return ++intArray[0]
}

// 기본적으로 위치 기반 인자 방식 이지만, 코틀린에서는 이름 붙은 인자도 사용 가능
fun rectangleArea(height: Int, width: Int): Int {
    return height * width
}