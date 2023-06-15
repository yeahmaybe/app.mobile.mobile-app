package app.mobile.features.task_crud

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDateTime


@Serializable
data class TaskCreateReceiveRemote(
    val label :String,
    val description: String?,
    val deadline_dt: String?
)


@Serializable
data class TaskCreateResponseRemote(
    val id: String
)

@Serializable
data class TaskModelRemote(
    val id: String,
    val label: String,
    val description: String?,
    val completed: Boolean,
    val deadline_dt: String?
)

