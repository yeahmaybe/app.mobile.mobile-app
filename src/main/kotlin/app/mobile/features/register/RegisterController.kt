package app.mobile.features.register

import app.mobile.cache.InMemoryCache
import app.mobile.cache.TokenCache
import app.mobile.database.tokens.TokenDTO
import app.mobile.database.tokens.Tokens
import app.mobile.database.users.UserDTO
import app.mobile.database.users.Users
import app.mobile.utils.getSalt
import app.mobile.utils.hashPassword
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.util.*

class RegisterController(val call: ApplicationCall) {

    suspend fun registerUser() {
        val registerReceiveRemote = call.receive<RegisterReceiveRemote>()
        val userDTO = Users.fetchUserByLogin(registerReceiveRemote.login)

        if(userDTO != null) {
            call.respond(HttpStatusCode.Conflict, "Пользователь существует")
        } else {
            val userId =  UUID.randomUUID().toString()
            val salt = getSalt()

            val pwdHash = hashPassword(registerReceiveRemote.password, salt)

            Users.insert(
                UserDTO(
                    id = userId,
                    login = registerReceiveRemote.login,
                    username = registerReceiveRemote.login,
                    email = registerReceiveRemote.email,
                    password = pwdHash,
                    salt = salt
                )
            )

            val token = UUID.randomUUID().toString()
            Tokens.insert(
                TokenDTO(
                    id = UUID.randomUUID().toString(),
                    user_id = userId,
                    token = token
                )
            )

            call.respond(RegisterResponseRemote(token = token))
        }
    }
}