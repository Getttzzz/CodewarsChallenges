package com.codewars.data.model

import com.codewars.domain.model.Challenge
import com.codewars.domain.model.PaginatedData
import com.google.gson.annotations.SerializedName


data class ChallengeResponse(
    @SerializedName("totalPages")
    val totalPages: Int,
    @SerializedName("totalItems")
    val totalItems: Int,
    @SerializedName("data")
    val data: List<ChallengeDto>?,
)

internal fun ChallengeResponse.toDomain(): PaginatedData<Challenge> {
    return PaginatedData(
        data = data?.toDomain().orEmpty(),
        totalItems = totalItems,
        totalPages = totalPages,
    )
}
