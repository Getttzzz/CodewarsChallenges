package com.codewars.codewarschallenges.ui.challenges

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.codewars.codewarschallenges.ui.challenges.paging.ChallengesPager
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ChallengesViewModel(challengesPager: ChallengesPager) : ViewModel() {

    val challenges = challengesPager.pagingDataFlow
        .catch { error -> onError(error) }
        .cachedIn(viewModelScope)

    var error by mutableStateOf<Throwable?>(value = null)
        private set

    fun onError(throwable: Throwable) {
        viewModelScope.launch { error = throwable }
    }

    fun onErrorConsumed() {
        viewModelScope.launch { error = null }
    }
}
