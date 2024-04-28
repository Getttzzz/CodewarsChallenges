package com.codewars.codewarschallenges.di

import com.codewars.codewarschallenges.ui.challangedetails.ChallengeDetailsViewModel
import com.codewars.codewarschallenges.ui.challenges.ChallengesViewModel
import com.codewars.codewarschallenges.ui.challenges.paging.ChallengesPager
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { params ->
        ChallengesViewModel(
            challengesPager = ChallengesPager(
                userName = params.get(),
                getChallengesUseCase = get()
            )
        )
    }

    viewModel {
        ChallengeDetailsViewModel()
    }
}
