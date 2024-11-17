package ch3

fun main() {
    // Kotlin 에는 삼항연산자가 없는 대신, if 를 식으로 사용할 수 있다.
    // 단, 반드시 양 가지 (if-else) 가 있어야 한다
    val i1 = readln().toInt()
    val i2 = readln().toInt()

    val max = if(i1 > i2) i1 else i2
    println("max = $max")

    // 범위 (Range) - 값 사이의 수열을 표현하는 몇 가지 타입이 존재한다.
    // 해당 범위는 닫혀있기에 시작, 끝 값이 범위에 포함된다.
    val chars: CharRange = 'a'..'h'
    val twoDigits: IntRange = 10..99

    // in 연산자로 범위(Range) 안에 존재하는지 테스트 가능하다.
    println("99 in two Digits: ${99 in twoDigits}")

    // 반만 닫힌 범위 - until
    val twoDigits2 = 10 until 100
    println("100 not in two Digits: ${100 !in twoDigits2}")

    // 진행 (progression) - downTo, step (간격) 활용
    val intProgression = 10 downTo 1
    val intProgression2 = 15 downTo 1 step 3
    intProgression2.forEach { println(it) }

    println("Hello World!".substring(2..4))

    val sliceArray = IntArray(10) { it * it }.sliceArray(2..4)
    println(sliceArray.contentToString())
}