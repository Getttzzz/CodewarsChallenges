package com.codewars.data.repository

import com.codewars.data.api.CodewarsApi
import com.codewars.data.model.ChallengeResponse
import com.codewars.data.model.toDomain
import com.codewars.domain.model.Challenge
import com.codewars.domain.model.PaginatedData
import com.codewars.domain.repository.ChallengeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class ChallengeRepositoryImpl(private val remoteApi: CodewarsApi) : ChallengeRepository {

    override fun getChallenges(
        userName: String,
        page: Int,
    ): Flow<PaginatedData<Challenge>> = flow {
        val response = remoteApi.getChallenges(
            userName = userName,
            page = page,
        )
        emit(response)
    }.map(ChallengeResponse::toDomain)
}
