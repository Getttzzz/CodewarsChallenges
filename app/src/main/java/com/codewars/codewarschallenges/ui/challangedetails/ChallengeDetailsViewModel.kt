package com.codewars.codewarschallenges.ui.challangedetails

import androidx.lifecycle.ViewModel
import com.codewars.domain.usecase.GetChallengeDetailsUseCase

class ChallengeDetailsViewModel(
    challengeId: String,
    getChallengeDetailsUseCase: GetChallengeDetailsUseCase,
) : ViewModel() {

}
