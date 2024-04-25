package com.codewars.data.api

import com.codewars.data.model.ChallengeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CodewarsApi {

    @GET("api/v1/users/{userName}/code-challenges/completed")
    suspend fun getChallenges(
        @Path("userName") userName: String,
        @Query("page") page: Int,
    ): ChallengeResponse
}
