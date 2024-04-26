package com.codewars.codewarschallenges

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.codewars.domain.usecase.GetChallengesUseCase

class ChallengesPager(
    userName: String,
    getChallengesUseCase: GetChallengesUseCase,
    config: PagingConfig = PagingConfig(pageSize = 50),
) {

    val pagingDataFlow = Pager(config = config) {
        ChallengesPagingSource(
            userName = userName,
            getChallengesUseCase =  getChallengesUseCase,
        )
    }.flow
}
