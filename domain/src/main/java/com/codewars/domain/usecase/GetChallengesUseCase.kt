package com.codewars.domain.usecase

import com.codewars.domain.DomainResult
import com.codewars.domain.asDomainResult
import com.codewars.domain.model.Challenge
import com.codewars.domain.model.PaginatedData
import com.codewars.domain.repository.ChallengeRepository
import kotlinx.coroutines.flow.Flow

class GetChallengesUseCase(
    private val challengeRepository: ChallengeRepository,
) {
    data class Params(
        val userName: String,
        val page: Int = 1,
    )

    operator fun invoke(params: Params): Flow<DomainResult<PaginatedData<Challenge>>> {
        return challengeRepository.getChallenges(
            userName = params.userName,
            page = params.page,
        ).asDomainResult()
    }
}
