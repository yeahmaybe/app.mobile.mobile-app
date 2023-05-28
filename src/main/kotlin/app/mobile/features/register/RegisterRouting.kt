package app.mobile.features.register

import app.mobile.cache.InMemoryCache
import app.mobile.cache.TokenCache
import app.mobile.utils.isValidEmail
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Application.configureRegisterRouting() {
    routing {
        post("/signup") {
            val registerController = RegisterController(call)
            registerController.registerUser()

            val receive = call.receive<RegisterReceiveRemote>()
            if(!receive.email.isValidEmail()) {
                call.respond(HttpStatusCode.BadRequest, "Email не валидный")
            }


        }
    }
}