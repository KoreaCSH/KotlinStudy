package ch4

object Application {
    val name = "My Application"

    override fun toString(): String = name

    fun exit() {}
}

// Kotlin 의 객체 선언은 클래스와 상수를 합한 것이며 객체 선언을 통해 싱글턴
// 즉, 인스턴스가 단 하나만 존재하는 클래스를 만들 수 있다.
// 객체 정의는 thread-safe 하다.
fun main() {
    println(Application)

    // companion object 를 활용한 팩토리 메서드
    // companion object 로 지정함으로써 객체를 따로 호출하지 않고 바로 create() 호출 가능
    val array: Array<String> = arrayOf("John", "Choi")
    val app = ApplicationV2.createByArray(array)
    println(app)

    val arrayListOf: ArrayList<String> = arrayListOf("John", "Choi")
    val appByArrayList = ApplicationV2.createByArrayList(arrayListOf)
    println(appByArrayList)
}

// companion object (동반 객체)
class ApplicationV2 private constructor(val name: String) {
    companion object Factory {
        fun createByArray(args: Array<String>): ApplicationV2? {
            val name = args.firstOrNull() ?: return null
            return ApplicationV2(name)
        }

        fun createByArrayList(args: ArrayList<String>): ApplicationV2? {
            val name = args.firstOrNull() ?: return null
            return ApplicationV2(name)
        }
    }

    override fun toString(): String = name
}