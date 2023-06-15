package app.mobile.plugins

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabase() {
    Database.connect(
        url = "jdbc:postgresql://0.0.0.0:5432/mobile-app",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "postgres"
    )
}
