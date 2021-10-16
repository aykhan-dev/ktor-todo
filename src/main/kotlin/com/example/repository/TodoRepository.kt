package com.example.repository

import com.example.dto.TodoDTO

object TodoRepository {

    private val dummyPlace = mutableListOf<TodoDTO>()

    fun getTodos(): List<TodoDTO> {
        return dummyPlace
    }

    fun getTodo(id: Int): List<TodoDTO> {
        return dummyPlace.filter { it.id == id }
    }

    fun addTodo(todo: TodoDTO) {
        dummyPlace.add(todo)
    }

    fun searchTodo(text: String): List<TodoDTO> {
        return dummyPlace.filter { text in it.label }
    }

    fun updateTodo(todo: TodoDTO) {
        val old = dummyPlace.find { it.id == todo.id }
        old?.let {
            old.label = todo.label
            old.isDone = todo.isDone
        }
    }

    fun deleteTodo(id: Int) {
        dummyPlace.removeIf { it.id == id }
    }

}