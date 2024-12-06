import org.setu.AdministratorPanel

fun main() {
    val bank0 = BankApp()
    bank0.run()
}


class BankApp {


    // Initial  Variables
    private val filePath = "users.xml"

    private val bankScreens = Screens()
    private val admin = AdministratorPanel()
    private val accountHandler0 = AccountHandler()
    private lateinit var currentUser: User


    // Entry point for BankApp
    fun run() {
        init()
    }

    // Initializes the app after entry point
    private fun init() {
        // Load users from the file at the start
        accountHandler0.loadUsers(filePath)

        // Until a number of 0 - 2 is entered, it will keep running initScreen()
        var selection: Int
        do {
            selection = bankScreens.initScreen()

            when (selection) {
                1 -> initHandler(1) // login
                2 -> initHandler(2) // register
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
        // Prompt user for user ID and password
        val loginDetails = bankScreens.loginScreen() // Assuming this returns an array with userId and password
        val userId = loginDetails[0] // Convert userId to Int
        val password = loginDetails[1] as String

        // Check if userId is valid
        val user = accountHandler0.userList.find { it.bankId == userId }

        if (user != null) {
            // Check if password matches said user
            if (user.password == password) {
                currentUser  = user // Sets the current user
                println("Login successful! Welcome, ${user.firstName}.")


                //Check currentUser account type and run corresponding menu
                if (currentUser.accountType == "Standard") {
                    runBank()
                } else if (currentUser.accountType == "Admin") {
                   admin.runAdminPanel()
                }
                // Run the bank after setting current user to corresponding user
            } else {
                println("Incorrect password. Please try again.")
            }
        } else {
            println("User  ID not found. Please try again.")
        }
    }

    private fun initRegister() {
        // Creates array with firstName, lastName, age, city, password
        val registerDetails = bankScreens.registerScreen()

        val validAccount: Boolean = accountHandler0.validateRegister(registerDetails)

        if (validAccount) {
            val user0 = accountHandler0.createUser(registerDetails)
            accountHandler0.userList.add(user0)
            currentUser = user0
            accountHandler0.saveUsers(filePath)
            println("Logging in")
            runBank()
        } else {
            initRegister()
        }

    }

    private fun runBank() {

        // Until a number of 0 - 4 is entered, it will keep running bankAppScreen()
        var selection: Int
        do {
            selection = bankScreens.bankAppScreen(currentUser)

            when (selection) {
                1 -> showBalance() //show balance
                2 -> handleDeposit() //Deposit
                3 -> handleWithdraw() // withdraw
                4 -> handleShowAccountDetails() // account details
            }
        } while (selection !in 0..4)
    }

    private fun handleDeposit() {
        // Get the deposit amount from the deposit screen
        val amount = bankScreens.depositScreen(currentUser)

        // Ensure amount is more than zero
        if (amount > 0) {
            currentUser.balance += amount
            println("Successfully deposited \$${amount}. Your new balance is: \$${currentUser.balance}.")

            // Save the updated balance to xml file
            accountHandler0.saveUsers(filePath)

            runBank()
        } else {
            println("Invalid deposit amount. Please enter a positive number.")
            handleDeposit()
        }
    }

    private fun handleWithdraw() {
        val amount = bankScreens.withdrawScreen(currentUser)

        if (amount > 0) {
            currentUser.balance -= amount
            println("Successfully withdrawed \$${amount}.")

            accountHandler0.saveUsers(filePath)

            runBank()
        } else {
            println("Invalid withdraw amount. Please enter a positive number.")
            handleWithdraw()
        }
    }

    private fun showBalance() {
        println("Your current balance is: \$${currentUser.balance}")
        runBank()
    }

    private fun handleShowAccountDetails() {
        println(currentUser)
        runBank()
    }

}