package com.codewars.codewarschallenges.ui.challangedetails

import com.codewars.domain.model.ChallengeDetails

data class ChallengeDetailsUIState(
    val challengeDetails: ChallengeDetails? = null,
    val isLoading: Boolean = false,
    val error: Throwable? = null,
)
