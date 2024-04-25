package com.codewars.domain.model

data class PaginatedData<T>(
    val data: List<T>,
    val totalItems: Int,
    val totalPages: Int,
)
