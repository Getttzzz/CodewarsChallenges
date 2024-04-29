package com.codewars.domain.model

data class ChallengeDetails(
    val id: String,
    val name: String,
    val languages: List<String>,
    val url: String,
    val rank: Rank,
    val description: String,
    val totalAttempts: Int,
    val totalCompleted: Int,
    val totalStars: Int, //how many times it was bookmarked
    val createdBy: ChallengeAuthor,
    val tags: List<String>,
)

data class Rank(
    val id: Int,
    val name: String,
    val color: String,
)

data class ChallengeAuthor(
    val userName: String,
    val url: String,
)
