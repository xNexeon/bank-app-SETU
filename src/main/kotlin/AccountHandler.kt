class AccountHandler {
    fun tryRegister(array: Array<Any>){
        if (array.isNotEmpty()){
            if (array[0] is String && (array[0] as String).length >= 3){
                if (array[1] is String && (array[1] as String).length >= 3){
                    if (array[2] is Int && (array[2] as Int) >= 18){
                        if (array[3] is String && (array[3] as String).length >= 4){
                            if (array[4] is String && (array[4] as String).length >= 8){
                                println("Valid account entered!! ")
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
    }
}