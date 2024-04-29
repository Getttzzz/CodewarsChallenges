package com.codewars.data.model

import com.codewars.domain.model.ChallengeAuthor
import com.codewars.domain.model.ChallengeDetails
import com.codewars.domain.model.Rank
import com.google.gson.annotations.SerializedName


/**
 * {
 *     "id": "5949481f86420f59480000e7",
 *     "name": "Odd or Even?",
 *     "slug": "odd-or-even",
 *     "category": "reference",
 *     "publishedAt": "2017-06-20T16:07:05.006Z",
 *     "approvedAt": "2017-07-25T21:29:46.017Z",
 *     "languages": [
 *         "javascript",
 *         "java",
 *         "crystal",
 *         "csharp",
 *     ],
 *     "url": "https://www.codewars.com/kata/5949481f86420f59480000e7",
 *     "rank": {
 *         "id": -7,
 *         "name": "7 kyu",
 *         "color": "white"
 *     },
 *     "createdAt": "2017-06-20T16:06:55.776Z",
 *     "createdBy": {
 *         "username": "ethaning",
 *         "url": "https://www.codewars.com/users/ethaning"
 *     },
 *     "approvedBy": {
 *         "username": "JohanWiltink",
 *         "url": "https://www.codewars.com/users/JohanWiltink"
 *     },
 *     "description": "### Task:\n\nGiven a list of integers, determine whether the sum of its elements is odd or even.\n\nGive your answer as a string matching `\"odd\"` or `\"even\"`.\n\nIf the input array is empty consider it as: `[0]` (array with a zero).\n\n### Examples:\n\n```\nInput: [0]\nOutput: \"even\"\n\nInput: [0, 1, 4]\nOutput: \"odd\"\n\nInput: [0, -1, -5]\nOutput: \"even\"\n```\n\n\nHave fun!\n",
 *     "totalAttempts": 254133,
 *     "totalCompleted": 129055,
 *     "totalStars": 611,
 *     "voteScore": 7898,
 *     "tags": [
 *         "Fundamentals",
 *         "Arrays"
 *     ],
 *     "contributorsWanted": true,
 *     "unresolved": {
 *         "issues": 2,
 *         "suggestions": 0
 *     }
 * }
 * */
data class ChallengeDetailsResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String?,
    @SerializedName("languages")
    val languages: List<String>?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("rank")
    val rank: RankDto?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("totalAttempts")
    val totalAttempts: Int?,
    @SerializedName("totalCompleted")
    val totalCompleted: Int?,
    @SerializedName("totalStars")
    val totalStars: Int?, //how many times it was bookmarked
    @SerializedName("createdBy")
    val createdBy: ChallengeAuthorDto?,
    @SerializedName("tags")
    val tags: List<String>?,
)

data class RankDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("color")
    val color: String?,
)

data class ChallengeAuthorDto(
    @SerializedName("username")
    val userName: String,
    @SerializedName("url")
    val url: String,
)

internal fun ChallengeDetailsResponse.toDomain(): ChallengeDetails {
    return ChallengeDetails(
        id = id,
        name = name ?: "No challenge name",
        languages = languages.orEmpty(),
        url = url.orEmpty(),
        rank = Rank(
            id = rank?.id ?: -999,
            name = rank?.name ?: "No name",
            color = rank?.color ?: "No color",
        ),
        description = description ?: "No description",
        totalAttempts = totalAttempts ?: -1,
        totalCompleted = totalCompleted ?: -1,
        totalStars = totalStars ?: -1,
        createdBy = ChallengeAuthor(
            userName = createdBy?.userName ?: "No username",
            url = createdBy?.url ?: "No url"
        ),
        tags = tags.orEmpty()
    )
}
