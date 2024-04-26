package com.codewars.codewarschallenges

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.codewars.domain.usecase.GetChallengesUseCase

class ChallengesPager(
    userName: String,
    getChallengesUseCase: GetChallengesUseCase,
    config: PagingConfig = PagingConfig(pageSize = PAGE_SIZE),
) {

    val pagingDataFlow = Pager(config = config) {
        ChallengesPagingSource(
            userName = userName,
            getChallengesUseCase = getChallengesUseCase,
        )
    }.flow

    companion object {
        private const val PAGE_SIZE = 200
    }
}
