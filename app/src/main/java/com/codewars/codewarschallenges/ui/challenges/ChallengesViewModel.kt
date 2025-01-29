package com.codewars.codewarschallenges.ui.challenges


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.codewars.codewarschallenges.ui.challenges.paging.ChallengesPager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ChallengesViewModel(challengesPager: ChallengesPager) : ViewModel() {

    val challenges = challengesPager.pagingDataFlow
        .catch { error -> onError(error) }
        .cachedIn(viewModelScope)

    private val _error = MutableStateFlow<Throwable?>(null)
    val error = _error.asStateFlow()

    fun onError(throwable: Throwable) {
        viewModelScope.launch { _error.value = throwable }
    }

    fun onErrorConsumed() {
        viewModelScope.launch { _error.value = null }
    }
}
