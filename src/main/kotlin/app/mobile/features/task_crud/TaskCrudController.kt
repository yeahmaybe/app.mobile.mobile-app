package app.mobile.features.task_crud

import app.mobile.database.tasks.TaskDTO
import app.mobile.database.tasks.Tasks
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class TaskCrudController(val call: ApplicationCall) {

    suspend fun createTask() {
        val taskCreateReceiveRemote = call.receive<TaskCreateReceiveRemote>()

        val taskId =  UUID.randomUUID().toString()

        Tasks.insert(
            TaskDTO(
                id = taskId,
                label = taskCreateReceiveRemote.label,
                description = taskCreateReceiveRemote.description,
                completed = false,
                deadline_dt = taskCreateReceiveRemote.deadline_dt
            )
        )

        call.respond(TaskCreateResponseRemote(id = taskId))
    }

    suspend fun deleteTask(id: String) {
        val task = Tasks.fetchTaskById(id)
        if (task == null) {
            call.respond(HttpStatusCode.Conflict, "Задачи не существует")
        } else {
            Tasks.delete(id)
            call.respond(HttpStatusCode.OK, "Задача удалена")
        }
    }

    suspend fun getTask(id: String) {
        val task = Tasks.fetchTaskById(id)
        if (task == null) {
            call.respond(HttpStatusCode.Conflict, "Задачи с таким ID не существует")
        } else {
            call.respond(
                TaskModelRemote(
                    id = task.id,
                    label = task.label,
                    description = task.description,
                    completed = task.completed,
                    deadline_dt = task.deadline_dt
                )
            )
        }
    }

    suspend fun getAllTasks() {
        val tasks = Tasks.fetchAll()
        if (tasks == null) {
            call.respond(HttpStatusCode.Conflict, "Нет задач")
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


}