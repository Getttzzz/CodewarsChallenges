package com.codewars.codewarschallenges.ui.challenges

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.codewars.codewarschallenges.ui.challenges.paging.ChallengesPager

class ChallengesViewModel(challengesPager: ChallengesPager) : ViewModel() {

    val challenges = challengesPager.pagingDataFlow.cachedIn(scope = viewModelScope)

}
