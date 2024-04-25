package com.codewars.codewarschallenges

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.codewars.domain.model.Challenge
import com.codewars.domain.usecase.GetChallengesUseCase

class ChallengesPagingSource(
    private val getChallengesUseCase: GetChallengesUseCase,
) : PagingSource<Int, Challenge>() {

    override fun getRefreshKey(state: PagingState<Int, Challenge>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Challenge> {
        TODO("Not yet implemented")
    }
}
