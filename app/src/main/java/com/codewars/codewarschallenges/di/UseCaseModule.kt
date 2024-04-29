package com.codewars.codewarschallenges.di

import com.codewars.domain.usecase.GetChallengeDetailsUseCase
import com.codewars.domain.usecase.GetChallengesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetChallengesUseCase(get()) }
    factory { GetChallengeDetailsUseCase(get()) }
}
