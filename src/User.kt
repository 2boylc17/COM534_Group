abstract class User (idIn: String, usernameIn:String, passwordIn:String, phoneNumberIn:String) {
    private val id: String = idIn
    private val username: String = usernameIn
    private val password: String = passwordIn
    private val phoneNumber: String = phoneNumberIn

    abstract fun reserveRoom(): String


}

class Student(idIn: String, usernameIn: String, passwordIn: String, phoneNumberIn: String) : User(idIn, usernameIn, passwordIn, phoneNumberIn) {
    override fun reserveRoom(): String {
        return ""
    }
}
