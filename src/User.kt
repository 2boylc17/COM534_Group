class User(idIn: String, usernameIn: String, passwordIn: String, phoneNumberIn: String, adminIn: Boolean){

    var id: String = idIn
    var username: String = usernameIn
    var password: String = passwordIn
    var phoneNumber: String = phoneNumberIn
    var admin: Boolean = adminIn

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
