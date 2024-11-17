abstract class User (idIn: String, usernameIn:String, passwordIn:String, phoneNumberIn:String, adminIn:Boolean) {
    private val id: String = idIn
    private val username: String = usernameIn
    private val password: String = passwordIn
    private val phoneNumber: String = phoneNumberIn
    private val admin: Boolean = adminIn

    abstract fun reserveRoom(): String


}

class Student(idIn: String, usernameIn: String, passwordIn: String, phoneNumberIn: String, adminIn: Boolean) : User(idIn, usernameIn, passwordIn, phoneNumberIn, adminIn) {
    override fun reserveRoom(): String {
        return ""
    }
}
