package app.mobile.database.users

import java.time.LocalDateTime

class UserDTO(
    val id: String,
    val login: String,
    val username: String,
    val email: String?,
    val password: String,
    val salt: String
)