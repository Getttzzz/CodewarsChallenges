package com.codewars.codewarschallenges.ui.challangedetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codewars.domain.DomainResult.Error
import com.codewars.domain.DomainResult.Loading
import com.codewars.domain.DomainResult.Success
import com.codewars.domain.usecase.GetChallengeDetailsUseCase
import kotlinx.coroutines.launch

class ChallengeDetailsViewModel(
    challengeId: String,
    getChallengeDetailsUseCase: GetChallengeDetailsUseCase,
) : ViewModel() {

    var state by mutableStateOf(ChallengeDetailsUIState())
        private set

    init {
        viewModelScope.launch {
            getChallengeDetailsUseCase.invoke(challengeId).collect {
                state = when (it) {
                    is Loading -> state.copy(challengeDetails = null, isLoading = true, error = null)
                    is Success -> state.copy(challengeDetails = it.value, isLoading = false, error = null)
                    is Error -> state.copy(challengeDetails = null, isLoading = false, error = it.exception)
                }
            }
        }
    }

}
