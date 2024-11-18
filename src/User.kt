import java.util.*

abstract class User (idIn: String, usernameIn:String, passwordIn:String, phoneNumberIn:String, adminIn:Boolean) {
    var id: String = idIn
    var username: String = usernameIn
    var password: String = passwordIn
    var phoneNumber: String = phoneNumberIn
    var admin: Boolean = adminIn

    abstract fun reserveRoom(): String


}

class Student(idIn: String, usernameIn: String, passwordIn: String, phoneNumberIn: String, adminIn: Boolean) : User(idIn, usernameIn, passwordIn, phoneNumberIn, adminIn) {
    override fun reserveRoom(): String {
        return ""
    }

    fun modifyUser(attribute: String, modification: String) {
        when (attribute) {
            "Id" -> id = modification
            "Username" -> username = modification
            "Password" -> password = modification
            "PhoneNumber" -> phoneNumber = modification
            "Admin" -> admin = !admin
        }
    }

}
