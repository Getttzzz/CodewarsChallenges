package com.codewars.codewarschallenges.usecase

import app.cash.turbine.test
import com.codewars.codewarschallenges.ChallengeDetailsTestData
import com.codewars.domain.DomainResult
import com.codewars.domain.repository.ChallengeRepository
import com.codewars.domain.usecase.GetChallengeDetailsUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class GetChallengeDetailsUseCaseTest {

    private val repository = mockk<ChallengeRepository>()
    private val systemUnderTest = GetChallengeDetailsUseCase(repository)


    @Test
    fun `result flow emits Loading`() = runTest {
        every { repository.getChallengeDetails(any()) } returns flowOf(ChallengeDetailsTestData)
        systemUnderTest("123").test {
            val actual = awaitItem()
            skipItems(count = 1)
            awaitComplete()

            Assert.assertTrue(actual is DomainResult.Loading)
        }
    }

    @Test
    fun `result flow emits Success`() = runTest {
        every { repository.getChallengeDetails(any()) } returns flowOf(ChallengeDetailsTestData)
        systemUnderTest("123").test {
            skipItems(count = 1)
            val actual = awaitItem()
            val expected = DomainResult.Success(value = ChallengeDetailsTestData)
            awaitComplete()

            Assert.assertEquals(expected, actual)
        }
    }

    @Test
    fun `result flow emits Error`() = runTest {
        every { repository.getChallengeDetails(any()) } returns flow { throw NullPointerException() }
        systemUnderTest("123").test {
            skipItems(count = 1)
            val actual = awaitItem()
            awaitComplete()

            Assert.assertTrue(actual is DomainResult.Error)
        }
    }
}
