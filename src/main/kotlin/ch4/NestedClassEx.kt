package ch4

// 단, 바깥 클래스는 자신에게 내포된 클래스의 비공개 멤버에 접근할 수 없다.
// 해당 코드는 java 의 static class 와 비슷
class PersonNC(val id: Id, val age: Int) {
    class Id(val firstName: String, val lastName: String)
    fun showMe() = println("${id.firstName} ${id.lastName}, $age")
}

// inner 를 붙이면 내부 인스턴스 클래스가 되는 듯 (그래서 자신을 둘러싼 외부 클래스의 현재 인스턴스에 접근 가능)
class PersonNCV2(val firstName: String, val lastName: String) {
    inner class Possession(val description: String) {
        fun showOwner() = println(fullName())

        // 내부 클래스에서 외부 클래스를 가리켜야 한다면 한정된 this (this@외부클래스) 를 이용해야 한다.
        fun getOwner() = this@PersonNCV2
    }

    val Money = this.Possession("Money")

    fun fullName() = "$firstName $lastName"

    override fun toString(): String {
        return "PersonNCV2(firstName='$firstName', lastName='$lastName')"
    }

}


fun main() {
    val id = PersonNC.Id("John", "Doe")
    val p1 = PersonNC(id, 26)
    p1.showMe()

    val p2 = PersonNCV2("John", "Doe")
    val wallet = p2.Possession("Wallet")
    wallet.showOwner()

    p2.Money.showOwner()
    println("wallet: $wallet, money: ${p2.Money}")

    println(wallet.getOwner())
}