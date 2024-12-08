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
        println("""
            Select user type to add:
            [1]: Customer
            [2]: Employee
            [3]: Administrator
        """.trimIndent())

        val selection = readln().toInt()

        when (selection) {
            1 -> println() // add customer
            2 -> println() // add employee
            3 -> println() // add admin
        }
    }



}