package app.mobile.database.tasks

import org.jetbrains.exposed.sql.javatime.Time
import java.sql.Timestamp
import java.time.LocalDateTime

class TaskDTO (
    val label: String?,
    val description: String?,
    val deadline_dt: LocalDateTime?
)