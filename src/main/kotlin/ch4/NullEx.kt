package ch4

fun main() {
    println(isLetterString("abc"))

    // String 은 null 을 받을 수 있는 타입이 아니므로 NPE 를 컴파일 시점에 방지해준다.
    // println(isLetterString(null))

    println(isBooleanString(null))

    val nullableStr: String? = "str"
    // Kotlin 에서 nullable type 은 null 이 될 수 없는 타입의 상위타입이므로 아래는 불가능하다.
    // val notNullableStr: String = nullableStr
}

fun isLetterString(str: String): Boolean {
    if(str.isEmpty()) return false
    for(ch in str) {
        if(!ch.isLetter()) return false
    }
    return true
}

// 타입 뒤에 물음표 (?) 를 붙여서 'null 이 될 수 있는 타입'으로 지정할 수 있다.
fun isBooleanString(str: String?) = str == "false" || str == "true"

// smart cast
fun isLetterStringV2(str: String?): Boolean {
    // 파라미터가 nullable 일 때, 파라미터 null 여부를 체크하는 로직을 추가해야 아래 로직에서 컴파일 에러가 발생하지 않는다.
    // 이를 smart cast 라고 하며, null 에 대한 동등성 검사 로직 이후 컴파일러는 nullable type 을 null 이 될 수 없는 타입으로 cast 한다.
    if(str == null) return false

    if(str.isEmpty()) return false
    for(ch in str) {
        if(!ch.isLetter()) return false
    }
    return true
}

// when 에서도 smart cast 작동한다.
fun describeNumber(i: Int?): String = when(i) {
    null -> "null"
    in 0..10 -> "small"
    in 11..20 -> "medium"
    else -> "other"
}

// ||, && 연산의 오른쪽에서도 smart cast 작동한다.
fun isSingleChar(str: String?): Boolean = str != null && str.length == 1