package com.example.plugins

import com.example.repository.TodoRepository
import com.example.dto.SearchDTO
import com.example.dto.TodoDTO
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {

    routing {

        get("/") {
            call.respondText("todo-list-project")
        }

        get("/todos") {
            val todos = TodoRepository.getTodos()
            call.respond(todos)
        }

        get("/todos/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null) call.respond(HttpStatusCode.BadRequest)
            val todo = TodoRepository.getTodo(id!!)
            call.respond(todo)
        }

        post("/todos") {
            val body = call.receive<TodoDTO>()
            TodoRepository.addTodo(body)
            call.respond(HttpStatusCode.Created)
        }

        post("/todos/search") {
            val body = call.receive<SearchDTO>()
            val result = TodoRepository.searchTodo(body.text)
            call.respond(result)
        }

        put("/todos") {
            val body = call.receive<TodoDTO>()
            TodoRepository.updateTodo(body)
            call.respond(HttpStatusCode.OK)
        }

        delete("/todos/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null) call.respond(HttpStatusCode.BadRequest)
            TodoRepository.deleteTodo(id!!)
            call.respond(HttpStatusCode.OK)
        }

    }

}
