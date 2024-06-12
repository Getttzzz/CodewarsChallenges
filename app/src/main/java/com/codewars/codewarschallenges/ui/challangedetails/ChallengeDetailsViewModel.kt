package com.codewars.codewarschallenges.ui.challangedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codewars.domain.DomainResult.Error
import com.codewars.domain.DomainResult.Loading
import com.codewars.domain.DomainResult.Success
import com.codewars.domain.usecase.GetChallengeDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChallengeDetailsViewModel(
    challengeId: String,
    getChallengeDetailsUseCase: GetChallengeDetailsUseCase,
) : ViewModel() {

    private val state = MutableStateFlow(ChallengeDetailsUIState())
    val readOnlyState = state.asStateFlow()

    init {
        viewModelScope.launch {
            getChallengeDetailsUseCase.invoke(challengeId).collect {
                state.value = when (it) {
                    is Loading -> state.value.copy(challengeDetails = null, isLoading = true, error = null)
                    is Success -> state.value.copy(challengeDetails = it.value, isLoading = false, error = null)
                    is Error -> state.value.copy(challengeDetails = null, isLoading = false, error = it.exception)
                }
            }
        }
    }

}
