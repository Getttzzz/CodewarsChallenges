package com.codewars.codewarschallenges.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.codewars.codewarschallenges.ui.challenges.paging.ChallengesPager
import kotlinx.coroutines.launch

class MainViewModel(challengesPager: ChallengesPager) : ViewModel() {

    val challenges = challengesPager.pagingDataFlow.cachedIn(scope = viewModelScope)

    var error by mutableStateOf<Throwable?>(value = null)
        private set

    fun onError(error: Throwable) {
        viewModelScope.launch {
            this@MainViewModel.error = error
        }
    }

    fun onErrorConsumed() {
        viewModelScope.launch {
            this@MainViewModel.error = null
        }
    }
}
