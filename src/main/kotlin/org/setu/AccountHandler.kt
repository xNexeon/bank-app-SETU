import com.thoughtworks.xstream.XStream
import java.io.File
import java.io.FileWriter


class AccountHandler {

    val userList = ArrayList<User>()

    // Nested if statements which return a boolean based on whether each
    // slot in the provided array has the correct length and data type
    //
    // If user inputs wrong data type, it will still throw the relevant
    // error message as it's casted as a String
    // It will keep asking user for input even if its invalid, and will print
    // the relevant error AFTER the user filled in ALL details
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
        // Find next bankId
        val nextBankId = userList.maxOfOrNull { it.bankId }?.plus(1) ?: 1 // If userList is empty, start with 1

        val user = User(
            firstName = (array[0] as String).lowercase(),
            lastName = (array[1] as String).lowercase(),
            age = array[2] as Int,
            city = (array[3] as String).lowercase(),
            password = array[4] as String,
            bankId = nextBankId
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

    // Function to load users (absolute pain)
    fun loadUsers(filePath: String) {
        //Initialize xstream
        val xstream = XStream().apply {
            alias("user", User::class.java)
            allowTypes(arrayOf(User::class.java)) // XML file will not load without this line
        }


        val xmlFile = File(filePath) // Creates a File object which will point to xml file at the filepath
        if (!xmlFile.exists() && !xmlFile.canRead()) { //Checks if the file exists and if it is readable by xstream
            println("Error: File does not exist or cannot be read.")
            return
        }

        //Converts XML content into an object readable by kotlin
        val loadedUsers = xstream.fromXML(xmlFile) as? List<User> ?: run { // can be null, in which case you have to sign up to generate users.xml
            println("Error: Loaded data is not a valid list.")
            return
        }

        userList.apply { // runs the block of code on the object it is called from
            clear() //clears all elements from userList
            addAll(loadedUsers) // adds all elements from loadedUsers to the now empty userList
        }

        println("Loaded ${userList.size} users")
    }




}