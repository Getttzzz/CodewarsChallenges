package com.codewars.domain.repository

import com.codewars.domain.model.Challenge
import com.codewars.domain.model.PaginatedData
import kotlinx.coroutines.flow.Flow


interface ChallengeRepository {

    fun getChallenges(
        userName: String,
        page: Int,
    ): Flow<PaginatedData<Challenge>>

}
