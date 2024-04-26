package com.codewars.codewarschallenges.di

import com.codewars.codewarschallenges.ChallengesPager
import com.codewars.codewarschallenges.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { params ->
        MainViewModel(
            challengesPager = ChallengesPager(
                userName = params.get(),
                getChallengesUseCase = get()
            )
        )
    }
}
