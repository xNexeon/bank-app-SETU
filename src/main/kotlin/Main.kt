fun main() {
    val bank0 = BankApp()
    bank0.run()
}


class BankApp {
    // Init Variables
    private val bankScreens = Screens()
    private val accountHandler0 = AccountHandler()
    private lateinit var currentUser: User

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

        val validAccount: Boolean = accountHandler0.validateRegister(registerDetails)

        if (validAccount) {
            val user0 = accountHandler0.createUser(registerDetails)
            accountHandler0.userList.add(user0)
            currentUser = user0
            runBank()
        }

    }

    private fun runBank() {


        // Until a number of 0 - 2 is entered, it will keep running initScreen()
        var selection: Int
        do {
            selection = bankScreens.bankAppScreen(currentUser)

            when (selection) {
                1 -> println(1)
                2 -> println(2)
                3 -> println(3)
                4 -> println(4)
            }
        } while (selection !in 0..4)
    }


}