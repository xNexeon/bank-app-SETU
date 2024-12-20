// All screen string prints and selection in this file
//
// This abstracts code so that it cleans up rest of code elsewhere

class Screens {
    private var bankName = "Bank Of SETU"

    private fun clearScreen() {
        for (i in 1..20) {
            println()
        }
    }

    // ################################ General Bank Screens ##########################################

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

    fun bankAppScreen(currentUser: User): Int {
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
            #   [3]: Withdraw                  #
            #   [4]: Account Details           #
            #   [0]: Exit                      #
            ------------------------------------
            ####################################
            Selection: 
        """.trimIndent()

        println(bankAppScreenText)

        val selection = readln()
        return selection.toInt()
    }

    fun depositScreen(currentUser: User): Int {
        clearScreen()
        val depositScreenText = """
            ########### $bankName ###########
            #                                  #
            #         Welcome ${currentUser.firstName.replaceFirstChar { it.uppercase() }}        #
            ####################################
            How much would you like to deposit:    
            [Current balance]:  ${currentUser.balance}
   
            Enter an amount: 
        """.trimIndent()

        println(depositScreenText)

        val amount = readln()
        return amount.toInt()
    }

    fun withdrawScreen(currentUser: User): Int {
        clearScreen()
        val withdrawScreenText = """
            ########### $bankName ###########
            #                                  #
            #         Welcome ${currentUser.firstName.replaceFirstChar { it.uppercase() }}        #
            ####################################
            How much would you like to Withdraw:     
            [Current balance]:  ${currentUser.balance}
   
            Enter an amount: 
        """.trimIndent()

        println(withdrawScreenText)

        val amount = readln()
        return amount.toInt()
    }



    // ################################ Administrator Screens ##########################################
    fun adminScreen(): Int {
        clearScreen()
        val adminScreenText = """
            ########### $bankName ###########
            ######[Administrator Panel]#########
            #                                  #
            ####################################
            #  Please select an option:        #
            ------------------------------------
            #   [1]: List total users          #
            #   [2]: Search User by name       #
            #   [3]: Add a User                #
            #   [4]: Remove a User             #
            #   [5]: Update a user             #
            #   [0]: Exit                      # 
            ------------------------------------
            ####################################
            Selection: 
        """.trimIndent()

        println(adminScreenText)

        val selection = readln()
        return selection.toInt()
    }
}