package com.codewars.domain.model

data class Challenge(
    val id: String,
    val name: String,
    val completedLanguages: List<String>,
    val completedAt: String,
)
