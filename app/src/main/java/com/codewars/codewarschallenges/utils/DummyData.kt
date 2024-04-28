package com.codewars.codewarschallenges.utils

import com.codewars.domain.model.Challenge

val DummyLanguages = listOf("python", "kotlin", "javascript", "haskell", "csharp", "sql")

val DummyChallenge = Challenge(
    id = "some_id",
    name = "Find the missing latter",
    completedLanguages = DummyLanguages,
    completedAt = "2017-02-12T10:29:27.794Z",
)
