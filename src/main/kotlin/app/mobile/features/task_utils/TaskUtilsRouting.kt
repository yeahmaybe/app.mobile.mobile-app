package app.mobile.features.task_utils

import io.ktor.server.application.*
import io.ktor.server.routing.*


fun Application.configureTaskUtilsRouting() {
    routing {
        get("/task/uncompleted") {
            val taskController = TaskUtilsController(call)
            taskController.getUncompletedTasks()
        }
    }

    routing {
        put("/task/complete/{id}") {
            val taskController = TaskUtilsController(call)
            call.parameters["id"]?.let { it1 -> taskController.completeTask(it1) }
        }
    }


}