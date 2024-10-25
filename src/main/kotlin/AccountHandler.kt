class AccountHandler {

    // Nested if statements which return a boolean based on whether each
    // slot in the provided array has the correct length and data type
    //
    // If user inputs wrong data type, it will still throw the relevant
    // error message
    fun validateRegister(array: Array<Any>): Boolean {
        if (array.isNotEmpty()) {
            if (array[0] is String && (array[0] as String).length >= 3) {
                if (array[1] is String && (array[1] as String).length >= 3) {
                    if (array[2] is Int && (array[2] as Int) >= 18) {
                        if (array[3] is String && (array[3] as String).length >= 4) {
                            if (array[4] is String && (array[4] as String).length >= 8) {
                                println("[Valid account entered] ")
                                return true
                            } else {
                                println("Password must contain at least 8 characters, one capital letter, and 2 numbers")
                            }
                        } else {
                            println("City name is too short")
                        }
                    } else {
                        println("[You have to be 18 or older to register]")
                    }
                } else {
                    println("[Second name is too short]")
                }
            } else {
                println("[First name is too short]")
            }
        } else {
            println("[Array is empty]")
        }
        return false
    }

    // Takes in an array of "any" type and creates a User object with the relevant
    // variables lowercased for easier manipulation down the line
    fun createUser(array: Array<Any>) {
        val user = User(
            firstName = (array[0] as String).lowercase(),
            lastName = (array[1] as String).lowercase(),
            age = array[2] as Int,
            city = (array[3] as String).lowercase(),
            password = array[4] as String,
            bankId = 1
        )

        println(user.toString())
    }


    fun tryLogin(array: Array<Any>){
        if (array.isNotEmpty()){
            if (array[0] is String && (array[0] as String).length >= 3){
                
            } else {
                println("")
            }
        } else {
            println("[Array is empty]")
        }
    }
}