package app.mobile.database.tokens

import app.mobile.database.users.Users
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

object Tokens : Table() {

    private val id = Tokens.varchar("id", 50)
    private val user_id = Tokens.varchar("user_id", 50)
    private val token = Tokens.varchar("token", 50)

    fun insert(tokenDTO: TokenDTO) {
        transaction {
            Tokens.insert {
                it[id] = tokenDTO.id
                it[user_id] = tokenDTO.user_id
                it[token] = tokenDTO.token
            }
        }
    }
}