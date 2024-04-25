package com.codewars.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart


sealed interface DomainResult<out T> {
    data class Success<T>(val value: T) : DomainResult<T>
    data class Error(val exception: Throwable) : DomainResult<Nothing>
    data object Loading : DomainResult<Nothing>
}

fun <T> Flow<T>.asDomainResult(): Flow<DomainResult<T>> {
    return this
        .map<T, DomainResult<T>> { value -> DomainResult.Success(value = value) }
        .onStart { emit(DomainResult.Loading) }
        .catch { exception -> emit(DomainResult.Error(exception = exception)) }
}
