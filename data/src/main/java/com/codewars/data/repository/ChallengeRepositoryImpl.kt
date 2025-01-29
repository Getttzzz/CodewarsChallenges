package com.codewars.data.repository

import com.codewars.data.api.CodewarsApi
import com.codewars.data.model.ChallengeDetailsResponse
import com.codewars.data.model.ChallengesResponse
import com.codewars.data.model.toDomain
import com.codewars.domain.model.Challenge
import com.codewars.domain.model.ChallengeDetails
import com.codewars.domain.model.PaginatedData
import com.codewars.domain.repository.ChallengeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.flow.retryWhen
import retrofit2.HttpException

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
    }.retry(retries = RETRIES_COUNT) { cause ->
        if (cause is HttpException) {
            delay(RETRIES_DELAY)
            true
        } else {
            false
        }
    }.map(ChallengesResponse::toDomain)

    override fun getChallengeDetails(
        challengeId: String,
    ): Flow<ChallengeDetails> = flow {
        val response = remoteApi.getChallengeDetails(challengeId)
        emit(response)
    }.retry(retries = RETRIES_COUNT) { cause ->
        if (cause is HttpException) {
            delay(RETRIES_DELAY)
            true
        } else {
            false
        }
    }.map(ChallengeDetailsResponse::toDomain)

    companion object {
        private const val RETRIES_COUNT = 5L
        private const val RETRIES_DELAY = 3_000L
    }
}
