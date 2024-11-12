package ch2

fun main() {
    val i1 = 7
    val i2 = 4

    val floorDiv = i1.floorDiv(i2)
    val mod = i1.mod(i2)

    println(floorDiv)
    println(mod)

    val i3 = 13 shl 2
    println("13 shl 2 : $i3")

    val i4 = 13 shr 2
    println("13 shr 2 : $i4")

    val ch = 'a' + 1
    println("'a' + 1 : $ch")

    // Kotlin 의 NaN 은 어떤 값과도 같지 않다. 아래 결과는 false
    println(Double.NaN == Double.NaN)

    // NaN 은 Double 에서 가장 큰 값으로 취급된다.
    val set = sortedSetOf(Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, 0.0)
    println(set)
}