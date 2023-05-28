package app.mobile.database.users

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object Users: Table("users") {
    private val id = Users.varchar("id", 50)
    private val login = Users.varchar("login", 100)
    private val username = Users.varchar("username", 30)
    private val email =  Users.varchar("email", 50)
    private val password =  Users.varchar("password", 128)
    private val salt = Users.varchar("salt", 16)

    fun insert(userDTO: UserDTO) {
        transaction {
            Users.insert {
                it[login] = userDTO.login
                it[username] = userDTO.username
                it[email] = userDTO.email ?: ""
                it[password] = userDTO.password
                it[id] = userDTO.id
                it[salt] = userDTO.salt
            }
        }
    }

    fun fetchUserById(id: String): UserDTO? {
        return try {
            transaction {
                val userModel = Users.select { Users.id.eq(id) }.single()
                UserDTO(
                    id = userModel[Users.id],
                    login = userModel[login],
                    username = userModel[username],
                    email = userModel[email],
                    password = userModel[password],
                    salt = userModel[salt]
                )
            }
        } catch (e: NoSuchElementException) {
            null
        }
    }

    fun fetchUserByLogin(login: String): UserDTO? {
        return try {
            transaction {
                val userModel = Users.select { Users.login.eq(login) }.single()
                UserDTO(
                    id = userModel[Users.id],
                    login = userModel[Users.login],
                    username = userModel[username],
                    email = userModel[email],
                    password = userModel[password],
                    salt = userModel[salt]
                )
            }
        } catch (e: NoSuchElementException) {
            null
        }
    }
}