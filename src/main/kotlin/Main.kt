fun main() {
    val bank0 = BankApp()
    bank0.run()
}


class BankApp {
    // Init Variables
    private val bankScreens = Screens()

    // Entry point for BankApp
    fun run() {
        init()
    }

    // Initializes the app after entry point
    private fun init() {

        // Until a number of 0 - 2 is entered, it will keep running initScreen()
        var selection: Int
        do {
            selection = bankScreens.initScreen()

            when (selection) {
                1 -> initHandler(1)
                2 -> initHandler(2)
            }
        } while (selection !in 0..2)
    }

    // Takes an integer of "i" and runs the relative functions
    private fun initHandler(i: Int) {
        when (i) {
            1 -> initLogin()
            2 -> initRegister()
        }
    }

    private fun initLogin() {
        // Creates array with userId, password
        val loginDetails = bankScreens.loginScreen()

    }

    private fun initRegister() {
        // Creates array with firstName, lastName, age, city, password
        val registerDetails = bankScreens.registerScreen()

        // Creates an AccountHandler object in order to use its methods
        val accountHandler0 = AccountHandler()
        val validAccount: Boolean = accountHandler0.validateRegister(registerDetails)

        if (validAccount) {
            accountHandler0.createUser(registerDetails)
        }

    }

}