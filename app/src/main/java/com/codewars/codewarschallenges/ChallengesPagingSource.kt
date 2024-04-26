package com.codewars.codewarschallenges

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.codewars.domain.DomainResult
import com.codewars.domain.model.Challenge
import com.codewars.domain.model.PaginatedData
import com.codewars.domain.usecase.GetChallengesUseCase
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class ChallengesPagingSource(
    private val userName: String,
    private val getChallengesUseCase: GetChallengesUseCase,
) : PagingSource<Int, Challenge>() {

    override fun getRefreshKey(state: PagingState<Int, Challenge>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(anchorPosition = position)?.run {
                prevKey?.plus(1) ?: nextKey?.minus(1)
            }
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Challenge> {
        val page = params.key ?: STARTING_PAGE

        return runCatching {
            getChallengesUseCase(
                GetChallengesUseCase.Params(
                    userName = userName,
                    page = page,
                )
            )
                .filter { domainResult -> domainResult !is DomainResult.Loading }
                .onEach { domainResult -> if (domainResult is DomainResult.Error) throw domainResult.exception }
                .map { domainResult -> (domainResult as DomainResult.Success).value }
                .first()
        }.fold(
            onSuccess = { paginatedData ->
                LoadResult.Page(
                    data = paginatedData.data,
                    prevKey = prevKey(page),
                    nextKey = paginatedData.nextKey(page)
                )
            },
            onFailure = { exception -> LoadResult.Error(exception) },
        )
    }

    private fun prevKey(page: Int): Int? {
        return if (page == 1) null else page.minus(1)
    }

    private fun PaginatedData<Challenge>.nextKey(page: Int): Int? {
        return if (page >= totalPages) null else page.plus(1)
    }

    companion object {
        private const val STARTING_PAGE = 1
    }
}
