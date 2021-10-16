package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class TodoDTO(
    val id: Int,
    var label: String,
    var isDone: Boolean,
)