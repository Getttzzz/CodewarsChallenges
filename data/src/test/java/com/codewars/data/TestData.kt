package com.codewars.data

import com.codewars.data.model.ChallengeAuthorDto
import com.codewars.data.model.ChallengeDetailsResponse
import com.codewars.data.model.ChallengeDto
import com.codewars.data.model.ChallengesResponse
import com.codewars.data.model.RankDto

/*
* {
    "totalPages": 10,
    "totalItems": 1946,
    "data": [
        {
            "id": "589ebcb9926baae92e000001",
            "name": "ASCII letters from Number",
            "completedLanguages": [
                "python"
            ],
            "completedAt": "2017-02-12T10:29:27.794Z"
        },
        {
            "id": "589f50b55df162a6f4000032",
            "name": "Print all numbers and replace all `0` at `*`.",
            "completedLanguages": [
                "shell"
            ],
            "completedAt": "2017-02-12T10:16:22.913Z"
        },
      ]
    }
* */

val ChallengeDtoTestData1 = ChallengeDto(
    id = "589ebcb9926baae92e000001",
    name = "ASCII letters from Number",
    completedLanguages = listOf("python"),
    completedAt = "2017-02-12T10:29:27.794Z",
)

val ChallengeDtoTestData2 = ChallengeDto(
    id = "589f50b55df162a6f4000032",
    name = "Print all numbers and replace all `0` at `*`.",
    completedLanguages = listOf("shell"),
    completedAt = "2017-02-12T10:16:22.913Z",
)

val ChallengesResponseTestData = ChallengesResponse(
    totalPages = 10,
    totalItems = 1946,
    data = listOf(ChallengeDtoTestData1, ChallengeDtoTestData2)
)

/*
* {
    "id": "5949481f86420f59480000e7",
    "name": "Odd or Even?",
    "category": "reference",
    "publishedAt": "2017-06-20T16:07:05.006Z",
    "approvedAt": "2017-07-25T21:29:46.017Z",
    "languages": [
        "javascript",
        "java",
        "python",
    ],
    "url": "https://www.codewars.com/kata/5949481f86420f59480000e7",
    "rank": {
        "id": -7,
        "name": "7 kyu",
        "color": "white"
    },
    "createdAt": "2017-06-20T16:06:55.776Z",
    "createdBy": {
        "username": "ethaning",
        "url": "https://www.codewars.com/users/ethaning"
    },
    "description": "### Task:\n\nGiven a list of integers, determine whether the sum of its elements is odd or even.\n\nGive your answer as a string matching `\"odd\"` or `\"even\"`.\n\nIf the input array is empty consider it as: `[0]` (array with a zero).\n\n### Examples:\n\n```\nInput: [0]\nOutput: \"even\"\n\nInput: [0, 1, 4]\nOutput: \"odd\"\n\nInput: [0, -1, -5]\nOutput: \"even\"\n```\n\n\nHave fun!\n",
    "totalAttempts": 254277,
    "totalCompleted": 129142,
    "totalStars": 611,
    "tags": [
        "Fundamentals",
        "Arrays"
    ]
}
* */
val ChallengeDetailsResponseTestData = ChallengeDetailsResponse(
    id = "5949481f86420f59480000e7",
    name = "Odd or Even?",
    languages = listOf("javascript", "java", "python"),
    url = "https://www.codewars.com/kata/5949481f86420f59480000e7",
    rank = RankDto(
        id = -7,
        name = "7 kyu",
        color = "white",
    ),
    description = "Some description",
    totalAttempts = 254277,
    totalCompleted = 129142,
    totalStars = 611,
    createdBy = ChallengeAuthorDto(
        userName = "ethaning",
        url = "https://www.codewars.com/users/ethaning",
    ),
    tags = listOf("Fundamentals", "Arrays"),
)
