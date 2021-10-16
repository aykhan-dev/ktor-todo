package com.example.dto

import kotlinx.serialization.Serializable

@Serializable
data class SearchDTO(
    val text: String,
)