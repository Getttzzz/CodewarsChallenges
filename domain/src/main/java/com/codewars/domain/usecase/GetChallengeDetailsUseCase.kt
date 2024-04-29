package com.codewars.domain.usecase

import com.codewars.domain.DomainResult
import com.codewars.domain.asDomainResult
import com.codewars.domain.model.ChallengeDetails
import com.codewars.domain.repository.ChallengeRepository
import kotlinx.coroutines.flow.Flow

class GetChallengeDetailsUseCase(
    private val challengeRepository: ChallengeRepository,
) {
    operator fun invoke(challengeId: String): Flow<DomainResult<ChallengeDetails>> {
        return challengeRepository.getChallengeDetails(challengeId).asDomainResult()
    }
}
