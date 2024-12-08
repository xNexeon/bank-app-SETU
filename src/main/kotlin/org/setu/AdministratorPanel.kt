package org.setu
import AccountHandler
import Screens

class AdministratorPanel {

    private val bankScreens = Screens()
    private val accountHandler0 = AccountHandler()
    private val filePath = "users.xml"

    // Runs the admin panel
    fun runAdminPanel() {

        accountHandler0.loadUsers(filePath)

        var selection: Int

        do{
            selection = bankScreens.adminScreen()
            when (selection) {
                1 -> adminListUsers() // List all users
                2 -> searchUserByName() // search user by name
                3 -> addUserInitialize() // add user
                4 -> println("remove user")
                5 -> println("update user")
                0 -> println("exit")
            }
        } while (selection != 0)


    }

    private fun adminListUsers() {
        accountHandler0.listUsers("users.xml")
        println("Press enter to continue")
        readln()
        runAdminPanel()
    }

    private fun searchUserByName() {
        println("Enter the first and last name of person to search for: ")
        val nameToSearch = readlnOrNull()?.lowercase() ?: ""

        // split user input into first and last name
        val fullName = nameToSearch.split(" ")
        // ensures user inputs both first and last name, and not just one
        if (fullName.size < 2) {
            println("Please enter both first and last name.")
            return
        }

        val firstNameToSearch = fullName[0]
        val lastNameToSearch = fullName[1]

        // filter users by their first and last name
        val foundUsers = accountHandler0.userList.filter {
            it.firstName.contains(firstNameToSearch, ignoreCase = true) &&
                    it.lastName.contains(lastNameToSearch, ignoreCase = true)
        }

        // print results
        if (foundUsers.isNotEmpty()) {
            println("Found users:")
            for (user in foundUsers) {
                println(user)
            }
            println()
            println("[Press enter to continue]")
            readln()
        } else {
            println("No users found with that name")
            println()
            println("[Press enter to continue]")
            readln()
        }

    }

    private fun addUserInitialize() {
        var userType = ""

        println("""
            Select user type to add:
            [1]: Customer/Standard
            [2]: Administrator
        """.trimIndent())

        val selection = readln().toInt()

        if (selection == 1) { // customer
            userType = "Standard"
        } else if (selection == 2) { // admin
            userType = "Admin"
        } else {
            println("Invalid section, please try again")
            addUserInitialize()
        }

        val registerDetails = bankScreens.registerScreen()

        if (userType == "Standard") {
            registerDetails[2]
        }

        val validAccount: Boolean = accountHandler0.validateRegister(registerDetails)

        if (validAccount) {
            val user0 = accountHandler0.createUser(registerDetails)
            accountHandler0.userList.add(user0)
            accountHandler0.saveUsers(filePath)
            println("Logging in")
        }


    }



}