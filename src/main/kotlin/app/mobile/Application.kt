package app.mobile

import app.mobile.features.login.configureLoginRouting
import app.mobile.features.register.configureRegisterRouting
import app.mobile.features.task_crud.configureTaskCrudRouting
import app.mobile.features.task_utils.configureTaskUtilsRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import app.mobile.plugins.*

fun main() {
    embeddedServer(CIO,
        port = 8082,
        host = "0.0.0.0",
        module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureDatabase()
    configureSerialization()
    configureRouting()
    configureLoginRouting()
    configureRegisterRouting()
    configureTaskCrudRouting()
    configureTaskUtilsRouting()
}
