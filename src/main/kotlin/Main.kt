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

    private fun init() {
        var selection: Int

        do {
            selection = bankScreens.initScreen()

            when (selection) {
                1 -> initHandler(1)
                2 -> initHandler(2)
            }
        } while (selection !in 0..2)
    }

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

    }

}