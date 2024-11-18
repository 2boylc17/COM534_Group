class Room(buildingIn: String, osIn: String) {
    var building = buildingIn
    var os = osIn

    fun modifyRoom(attribute: String, modification: String) {
        when (attribute) {
            "Building" -> building = modification
            "OS" -> os = modification
        }
    }

}