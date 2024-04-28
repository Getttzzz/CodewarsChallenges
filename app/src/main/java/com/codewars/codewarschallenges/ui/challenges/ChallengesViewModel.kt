package com.codewars.codewarschallenges.ui.challenges

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.codewars.codewarschallenges.ui.challenges.paging.ChallengesPager
import kotlinx.coroutines.launch

class ChallengesViewModel(challengesPager: ChallengesPager) : ViewModel() {

    init {
        println("GETZ.MainViewModel.init --> this=${this.hashCode()}")
    }

    val challenges = challengesPager.pagingDataFlow.cachedIn(scope = viewModelScope)

    var error by mutableStateOf<Throwable?>(value = null)
        private set

    fun onError(error: Throwable) {
        viewModelScope.launch {
            this@ChallengesViewModel.error = error
        }
    }

    fun onErrorConsumed() {
        viewModelScope.launch {
            this@ChallengesViewModel.error = null
        }
    }
}
