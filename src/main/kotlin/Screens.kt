class Screens{
    private var bankName = "Bank Of SETU"

    private fun clearScreen() {
        for (i in 1..20) {
            println()
        }
    }

    fun initScreen(): Int {
        clearScreen()

        val initScreenText = """
            ########### $bankName ###########
            #                                  #
            #         Login or Register        #
            ####################################
            #  Please select an option:        #
            ------------------------------------
            #   [1]: Login                     #
            #   [2]: Sign Up                   #
            #   [0]: Exit                      #
            ------------------------------------
            ####################################
            Selection: 
        """.trimIndent()
        print(initScreenText)

        val selection = readln()
        return selection.toInt()
    }

    fun loginScreen(): Array<Any> {
        clearScreen()
        val loginScreenText = """
            ########### $bankName ###########
            #              Login               #
            ####################################
        """.trimIndent()
        println(loginScreenText)

        print("User ID: ")
        val userId = readlnOrNull() ?: "0"
        val userIdInt = userId.toIntOrNull() ?: 0

        print("Password: ")
        val password = readlnOrNull() ?: ""

        println("####################################")

        return arrayOf(userIdInt, password)
    }

    fun registerScreen(): Array<Any> {
        clearScreen()
        val registerScreenText = """
            ########### $bankName ###########
            #            Register              #
            ####################################
        """.trimIndent()
        println(registerScreenText)

        print("First Name: ")
        val firstName = readlnOrNull() ?: ""

        print("Last Name: ")
        val lastName = readlnOrNull() ?: ""

        print("Age: ")
        val ageInput = readlnOrNull() ?: ""
        val age = ageInput.toIntOrNull() ?: 0

        print("City: ")
        val city = readlnOrNull() ?: ""

        print("Password: ")
        val password = readlnOrNull() ?: ""
        println("####################################")

        return arrayOf(firstName, lastName, age, city, password)
    }

    fun bankAppScreen(currentUser: User) {
        clearScreen()
        val bankAppScreenText = """
            ########### $bankName ###########
            #                                  #
            #         Welcome ${currentUser.firstName.replaceFirstChar { it.uppercase() }}        #
            ####################################
            #  Please select an option:        #
            ------------------------------------
            #   [1]: Check Balance             #
            #   [2]: Deposit                   #
            #   [3]: Withdraw
            #   [0]: Exit                      #
            ------------------------------------
            ####################################
            Selection: 
        """.trimIndent()

        println(bankAppScreenText)
    }
}