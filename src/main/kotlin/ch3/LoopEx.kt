package ch3

fun main() {

    // while, do-while 문은 Java 와 동일

    // for - Java 의 선언, 초기화, 검사 및 갱신으로 구성되는 일반적인 Java 의 for 루프에 해당하는 언어 구조는 X
    val intArray = IntArray(10) { it * it }
    var sum = 0

    for (x in intArray) {
        sum += x
    }

    println("sum = $sum")

    // Java 와 달리 for 를 활용하여 문자열의 각 문자에 대한 루프를 '바로' 수행할 수 있다. (toCharArray() 필요 X)
    val str = "String"
    for(c:Char in str) {
        if(c in 'a'..'z') println("$c is Lower Char")
    }

    // index 가 짝수인 원소만 두 배로 변경 (진행 - Progression 활용하면 조건문 피할 수 있다)
    val intArray2 = IntArray(10) { it * it }
    for (i in 0..intArray2.lastIndex step 2) {
        intArray2[i] *= 2
    }

    println(intArray2.contentToString())

}