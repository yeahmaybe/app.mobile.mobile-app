package app.mobile.features.login

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

import app.mobile.cache.InMemoryCache;
import app.mobile.cache.TokenCache
import io.ktor.http.*
import java.util.*

fun Application.configureLoginRouting() {
    routing {
        post("/login") {
            val receive = call.receive<LoginReceiveRemote>()
            val first = InMemoryCache.userList.firstOrNull {it.login == receive.login}

            if( first == null ){
                call.respond(HttpStatusCode.BadRequest, "Пользователь не найден")
            } else {
                if (first.password == receive.password) {
                    val token = UUID.randomUUID().toString()
                    InMemoryCache.token.add(TokenCache(login = receive.login, token = token))
                    call.respond(LoginResponseRemote(token = token))
                    return@post
                } else {
                    call.respond(HttpStatusCode.BadRequest, "Неверный пароль")
                }
            }
        }
    }
}
