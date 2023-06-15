package app.mobile.features.task_utils

import app.mobile.database.tasks.TaskDTO
import app.mobile.database.tasks.Tasks
import app.mobile.features.task_crud.TaskModelRemote
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import org.jetbrains.exposed.sql.update
import java.time.LocalDateTime

class TaskUtilsController(val call: ApplicationCall) {
    suspend fun getUncompletedTasks() {
        val tasks = Tasks.fetchUncompletedTasks()
        if (tasks == null) {
            call.respond(HttpStatusCode.Conflict, "Нет незавершенных задач")
        } else {
            call.respond(
                tasks.map {
                    TaskModelRemote(
                        id = it.id,
                        label = it.label,
                        description = it.description,
                        completed = it.completed,
                        deadline_dt = it.deadline_dt
                    )
                }
            )
        }
    }

    suspend fun completeTask(id: String) {
        val task = Tasks.fetchTaskById(id)
        if (task == null) {
            call.respond(HttpStatusCode.Conflict, "Задачи с таким ID не существует")
        } else {

            val newTask = TaskDTO (
                id = task.id,
                label = task.label,
                description = task.description,
                completed = true,
                deadline_dt = task.deadline_dt
            )

            Tasks.updateTask(newTask)
            call.respond(
                TaskModelRemote(
                    id = newTask.id,
                    label = newTask.label,
                    description = newTask.description,
                    completed = newTask.completed,
                    deadline_dt = newTask.deadline_dt
                )
            )
        }
    }
}
