package app.mobile.features.task_crud

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureTaskCrudRouting() {
    routing {
        post("/task/create") {
            val taskController = TaskCrudController(call)
            taskController.createTask()
        }
    }

    routing {
        delete("/task/{id}") {
            val taskController = TaskCrudController(call)
            call.parameters["id"]?.let { it1 -> taskController.deleteTask(it1) }
        }
    }

    routing {
        get("/task/{id}") {
            val taskController = TaskCrudController(call)
            call.parameters["id"]?.let { it1 -> taskController.getTask(it1) }
        }
    }

    routing {
        put("/task/{id}") {
            val taskController = TaskCrudController(call)
            taskController.createTask()
        }
    }

    routing {
        get("/task/all") {
            val taskController = TaskCrudController(call)
            taskController.getAllTasks()
        }
    }
}