package com.codewars.data.model

import com.codewars.domain.model.Challenge
import com.google.gson.annotations.SerializedName

/**
 * "id": "544675c6f971f7399a000e79",
 * "name": "Convert a String to a Number!",
 * "slug": "convert-a-string-to-a-number",
 * "completedLanguages": [
 *     "ruby"
 * ],
 * "completedAt": "2014-11-06T15:28:37.000Z"*/
data class ChallengeDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String?,
    @SerializedName("completedLanguages")
    val completedLanguages: List<String>?,
    @SerializedName("completedAt")
    val completedAt: String?,
)

internal fun List<ChallengeDto>.toDomain(): List<Challenge> {
    return map(ChallengeDto::toDomain)
}

internal fun ChallengeDto.toDomain(): Challenge {
    return Challenge(
        id = id,
        name = name.orEmpty(),
        completedLanguages = completedLanguages.orEmpty(),
        completedAt = completedAt.orEmpty(),
    )
}
