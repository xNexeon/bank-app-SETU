import com.thoughtworks.xstream.XStream
import java.io.File
import java.io.FileWriter


class AccountHandler {

    val userList = ArrayList<User>()

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
    fun createUser(array: Array<Any>): User {
        val user = User(
            firstName = (array[0] as String).lowercase(),
            lastName = (array[1] as String).lowercase(),
            age = array[2] as Int,
            city = (array[3] as String).lowercase(),
            password = array[4] as String,
            bankId = 1
        )
        return user
    }

    fun saveUsers(filePath: String) {
        val xstream = XStream()
        xstream.alias("user", User::class.java)

        val xml = xstream.toXML(userList)

        FileWriter(File(filePath)).use { writer ->
            writer.write(xml)
        }
    }

    fun loadUsers(filePath: String) {
        val xstream = XStream()
        xstream.alias("user", User::class.java)

        // Allow the User class for deserialization
        //xstream.addPermission(WildcardTypePermission("com.yourpackage.User")) // Replace with your actual package name

        val xmlFile = File(filePath)

        if (xmlFile.exists() && xmlFile.canRead()) {
            // Use a safe cast with 'as?' and handle the null case
            val loadedUsers = xstream.fromXML(xmlFile) as? List<*>

            if (loadedUsers != null) {
                userList.clear()
                // Filter the loaded users to ensure they are of type User
                loadedUsers.filterIsInstance<User>().let { userList.addAll(it) }
                println("Loaded ${userList.size} users")
            } else {
                println("Error: Loaded data is not a valid list.")
            }
        } else {
            println("Error loading file")
        }
    }


}