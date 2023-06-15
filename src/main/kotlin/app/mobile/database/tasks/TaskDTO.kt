package app.mobile.database.tasks

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.javatime.Time
import java.sql.Timestamp
import java.time.LocalDateTime

@Serializable
class TaskDTO(
    val id: String,
    val label: String,
    val description: String?,
    val completed: Boolean,
    val deadline_dt: String?
)