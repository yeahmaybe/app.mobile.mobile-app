package app.mobile.database.tasks

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.javatime.datetime
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime

object Tasks: Table("tasks") {
    private val label = Tasks.varchar("label", 100)
    private val description = Tasks.text("description")
    private val deadline_dt = Tasks.datetime("deadline_dt")

    fun insert(taskDTO: TaskDTO) {
        transaction {
            Tasks.insert {
                it[label] = taskDTO.label?: "Новая задача"
                it[description] = taskDTO.description?: ""
                it[deadline_dt] = taskDTO.deadline_dt?: LocalDateTime.of(9999,
                    12, 31, 23, 59, 59)

            }
        }
    }
}