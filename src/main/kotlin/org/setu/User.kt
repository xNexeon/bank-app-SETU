data class User(
    var firstName: String,
    var lastName: String,
    var age: Int,
    var city: String,
    var password: String,
    var bankId: Int,
    var balance: Int,
    var accountType: String

) {
    override fun toString(): String {
        return """
        User Details:
        First Name: $firstName
        Last Name: $lastName
        Age: $age
        City: $city
        Bank ID: $bankId
        Balance: $balance
    """.trimIndent()
    }
}