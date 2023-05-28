package app.mobile

import app.mobile.features.login.configureLoginRouting
import app.mobile.features.register.configureRegisterRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import app.mobile.plugins.*
import org.jetbrains.exposed.sql.Database

fun main() {
    Database.connect(
        url="jdbc:postgresql://localhost:5432/mobile-app",
        driver="org.postgresql.Driver",
        //user = "postgres",
        //password="postgres"
    )

    embeddedServer(CIO, port = 8081, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
    configureLoginRouting()
    configureRegisterRouting()
    //configureDatabases()
}
