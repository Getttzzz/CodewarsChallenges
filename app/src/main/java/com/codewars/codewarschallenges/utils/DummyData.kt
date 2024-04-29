package com.codewars.codewarschallenges.utils

import com.codewars.domain.model.Challenge
import com.codewars.domain.model.ChallengeAuthor
import com.codewars.domain.model.ChallengeDetails
import com.codewars.domain.model.Rank

val DummyLanguages = listOf("python", "kotlin", "javascript", "haskell", "csharp", "sql")

val DummyChallenge = Challenge(
    id = "some_id",
    name = "Find the missing latter",
    completedLanguages = DummyLanguages,
    completedAt = "2017-02-12T10:29:27.794Z",
)

val DummyChallengeDetails = ChallengeDetails(
    id = "some_id",
    "Odd or Even?",
    languages = listOf("kotlin", "javascript", "csharp", "haskell", "python"),
    url = "https://www.codewars.com/kata/5949481f86420f59480000e7",
    rank = Rank(8, "8 dan", "red"),
    description = "### Task:\\n\\nGiven a list of integers, determine whether the sum of its elements is odd or even.\\n\\nGive your answer as a string matching `\\\"odd\\\"` or `\\\"even\\\"`.\\n\\nIf the input array is empty consider it as: `[0]` (array with a zero).\\n\\n### Examples:\\n\\n```\\nInput: [0]\\nOutput: \\\"even\\\"\\n\\nInput: [0, 1, 4]\\nOutput: \\\"odd\\\"\\n\\nInput: [0, -1, -5]\\nOutput: \\\"even\\\"\\n```\\n\\n\\nHave fun!\\n",
    totalAttempts = 254133,
    totalCompleted = 129055,
    totalStars = 611,
    createdBy = ChallengeAuthor("ethaning", "https://www.codewars.com/users/ethaning"),
    tags = listOf("Fundamentals", "Arrays")
)
