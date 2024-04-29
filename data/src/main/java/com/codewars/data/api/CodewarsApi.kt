package com.codewars.data.api

import com.codewars.data.model.ChallengeDetailsResponse
import com.codewars.data.model.ChallengesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CodewarsApi {

    @GET("api/v1/users/{userName}/code-challenges/completed")
    suspend fun getChallenges(
        @Path("userName") userName: String,
        @Query("page") page: Int,
    ): ChallengesResponse

    @GET("api/v1/code-challenges/{challengeId}")
    suspend fun getChallengeDetails(
        @Path("challengeId") challengeId: String,
    ): ChallengeDetailsResponse
}
