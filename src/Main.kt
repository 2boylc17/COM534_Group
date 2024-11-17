fun main() {
    val peoplelist : MutableList<Student> = mutableListOf()
    peoplelist.add(Student("1","qwerty","asdfg","12345", true))
    val roomslist: MutableList<Room> = mutableListOf()
    roomslist.add(Room("Building 1","Windows"))
    roomslist.add(Room("Building 2","Linux"))
    menu(peoplelist, roomslist)
}

fun menu(peoplelist: MutableList<Student>, roomslist: MutableList<Room>) {
    println("What would you like to do? \n" +
            "1. Sign Up for an account \n" +
            "2. Change details of a room \n" +
            "3. Modify Users \n" +
            "4. Exit")
    val option = readln()
    when (option) {
        "1" -> {
            newUser(peoplelist, roomslist)
            menu(peoplelist, roomslist)
        }
        "2" -> {
            changeRoom(roomslist, peoplelist)
            menu(peoplelist, roomslist)
        }
        "3" -> {
            readln()
            menu(peoplelist, roomslist)
        }
        "4" -> {
            println("Thank You")
        }
        "5" -> {
            println(roomslist[0].building)
        }
        else -> {
            readln()
            menu(peoplelist, roomslist)
        }
    }
}

fun newUser(peoplelist: MutableList<Student>, roomslist: MutableList<Room>) {
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
    peoplelist.add(Student(id,name,password,number,admin))
}

fun changeRoom(roomslist: MutableList<Room>, peoplelist: MutableList<Student>) {
    var count = 0
    for (room in roomslist) {
        count += 1
        val building = room.building
        val os = room.os
        println("$count. $building, $os")

    }
    println("Which room would you like to change?")
    val answer = readln()
    when(val num = answer.toIntOrNull()){
        null -> {
            return
        }
        else -> {
            println("Would you like to change the Building or OS? (B/O)")
            val change = readln()
            if (change == "B") {
                println("What would you like to change it to?")
                val new = readln()
                roomslist[num - 1].building = new
            }
            if (change == "O") {
                println("What would you like to change it to?")
                val new = readln()
                roomslist[num - 1].os = new
            }
            else {
                return
            }
        }
    }
}

