fun main() {
    val peoplelist : MutableList<User> = mutableListOf()
    peoplelist.add(User("1","admin1","password1","12345", true))
    peoplelist.add(User("2","student1","password2","54321", false))
    peoplelist.add(User("3","student2","password3","89101", false))
    val roomslist: MutableList<Room> = mutableListOf()
    roomslist.add(Room("Building 1","Windows"))
    roomslist.add(Room("Building 2","Linux"))
    menu(peoplelist, roomslist)
}

fun menu(peoplelist: MutableList<User>, roomslist: MutableList<Room>) {
    val user = peoplelist[0]
    //setting user to an admin to allow parts h and j to work
    //if user is set to peoplelist[1] it will not allow the user to modify anything
    println("What would you like to do? \n" +
            "1. Sign Up for an account \n" +
            "2. Change details of a room \n" +
            "3. Modify Users \n" +
            "4. Exit")
    val option = readln()
    when (option) {
        "1" -> {
            newUser(peoplelist)
            menu(peoplelist, roomslist)
        }
        "2" -> {
            changeRoom(roomslist, user)
            menu(peoplelist, roomslist)
        }
        "3" -> {
            changeUser(peoplelist, user)
            menu(peoplelist, roomslist)
        }
        "4" -> {
            println("Thank You")
        }
        else -> {
            readln()
            menu(peoplelist, roomslist)
        }
    }
}

fun newUser(peoplelist: MutableList<User>) {
    println("What is the ID?")
    val id = readln()
    println("What is the username?")
    val name = readln()
    println("What is the password?")
    val password = readln()
    println("What is the phone number?")
    val number = readln()
    println("Is the user an admin? (Y/N)")
    val answer = readln()
    var admin = false
    if (answer == "Y"){
        admin = true
    }
    peoplelist.add(User(id,name,password,number,admin))
}

fun changeRoom(roomslist: MutableList<Room>, user: User) {
    if (user.admin) {
        var count = 0
        for (room in roomslist) {
            count += 1
            val building = room.building
            val os = room.os
            println("$count. $building, $os")

        }
        println("Which room would you like to change?")
        val answer = readln()
        when (val num = answer.toIntOrNull()) {
            null -> {
                return
            }
            else -> {
                println("Would you like to change the Building, OS or Delete the room? (B/O/D)")
                val change = readln()
                when (change) {
                    "B" -> {
                        println("What would you like to change it to?")
                        val new = readln()
                        roomslist[num - 1].modifyRoom("Building", new)
                    }

                    "O" -> {
                        println("What would you like to change it to?")
                        val new = readln()
                        roomslist[num - 1].modifyRoom("OS", new)
                    }
                    "D" -> {
                        roomslist.removeAt(num - 1)
                        println("Room removed")
                        readln()
                    }
                    else -> {
                        return
                    }
                }
            }
        }
    }
    else{
        print("User is not an admin")
        readln()
        return
    }
}

fun changeUser(peoplelist: MutableList<User>, user: User) {
    if (user.admin) {
        var count = 0
        for (people in peoplelist) {
            count += 1
            val id = people.id
            val username = people.username
            val password = people.password
            val number = people.phoneNumber
            val admin = people.admin
            println("$count. $id, $username, $password, $number, $admin")

        }
        println("Which user would you like to change?")
        val answer = readln()
        when (val num = answer.toIntOrNull()) {
            null -> {
                return
            }

            else -> {
                println("What would you like to change? Id, Username, Password, Phone Number, " +
                        "Admin Privileges or Delete the user? (I/U/P/N/A/D)")
                val change = readln()
                when (change) {
                    "I" -> {
                        println("What would you like to change it to?")
                        val new = readln()
                        peoplelist[num - 1].modifyUser("Id", new)
                    }
                    "U" -> {
                        println("What would you like to change it to?")
                        val new = readln()
                        peoplelist[num - 1].modifyUser("Username", new)
                    }
                    "P" -> {
                        println("What would you like to change it to?")
                        val new = readln()
                        peoplelist[num - 1].modifyUser("Password", new)
                    }
                    "N" -> {
                        println("What would you like to change it to?")
                        val new = readln()
                        peoplelist[num - 1].modifyUser("PhoneNumber", new)
                    }
                    "A" -> {
                        peoplelist[num - 1].modifyUser("Admin", "")
                        println("Admin Status Changed")
                    }
                    "D" -> {
                        peoplelist.removeAt(num - 1)
                        println("User removed")
                        readln()
                    }
                    else -> {
                        return
                    }
                }
            }
        }
    }
    else{
        print("User is not an admin")
        readln()
        return
    }
}

