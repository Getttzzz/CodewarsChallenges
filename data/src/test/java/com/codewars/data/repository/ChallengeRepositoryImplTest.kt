package com.codewars.data.repository

import com.codewars.data.ChallengeDetailsResponseTestData
import com.codewars.data.ChallengesResponseTestData
import com.codewars.data.api.CodewarsApi
import com.codewars.data.model.toDomain
import com.codewars.domain.repository.ChallengeRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class ChallengeRepositoryImplTest {

    private val api = mockk<CodewarsApi>()
    private val systemUnderTest: ChallengeRepository = ChallengeRepositoryImpl(api)

    @Test
    fun getChallenges() = runTest {
        val expected = ChallengesResponseTestData.toDomain()

        coEvery {
            api.getChallenges(any(), any())
        } returns ChallengesResponseTestData

        val actual = systemUnderTest.getChallenges("wichu", 1)
            .first()

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun getChallengeDetails() = runTest {
        val expected = ChallengeDetailsResponseTestData.toDomain()

        coEvery {
            api.getChallengeDetails(any())
        } returns ChallengeDetailsResponseTestData

        val actual = systemUnderTest.getChallengeDetails("5949481f86420f59480000e7")
            .first()

        Assert.assertEquals(expected, actual)
    }
}
