package com.codewars.codewarschallenges.usecase

import app.cash.turbine.test
import com.codewars.codewarschallenges.ChallengesPaginatedTestData
import com.codewars.domain.DomainResult
import com.codewars.domain.model.Challenge
import com.codewars.domain.model.PaginatedData
import com.codewars.domain.repository.ChallengeRepository
import com.codewars.domain.usecase.GetChallengesUseCase
import com.codewars.domain.usecase.GetChallengesUseCase.Params
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class GetChallengesUseCaseTest {

    private val repository = mockk<ChallengeRepository>()
    private val systemUnderTest = GetChallengesUseCase(repository)

    @Test
    fun `result flow emits Loading`() = runTest {
        every { repository.getChallenges(any(), any()) } returns flowOf(ChallengesPaginatedTestData)
        systemUnderTest(Params(userName = "wichu", page = 1)).test {
            val actual: DomainResult<PaginatedData<Challenge>> = awaitItem()
            println("GETZ.result flow emits Loading --> actual=$actual")
            skipItems(count = 1)
            awaitComplete()

            Assert.assertTrue(actual is DomainResult.Loading)
        }
    }

    @Test
    fun `result flow emits Success`() = runTest {
        every { repository.getChallenges(any(), any()) } returns flowOf(ChallengesPaginatedTestData)
        systemUnderTest(Params(userName = "wichu", page = 1)).test {
            skipItems(count = 1)
            val expected = DomainResult.Success(value = ChallengesPaginatedTestData)
            val actual: DomainResult<PaginatedData<Challenge>> = awaitItem()
            awaitComplete()

            Assert.assertEquals(expected, actual)
        }
    }

    @Test
    fun `result flow emits Error`() = runTest {
        every { repository.getChallenges(any(), any()) } returns flow { throw NullPointerException() }
        systemUnderTest(Params(userName = "wichu", page = 1)).test {
            skipItems(count = 1)
            val actual: DomainResult<PaginatedData<Challenge>> = awaitItem()

            awaitComplete()

            Assert.assertTrue(actual is DomainResult.Error)
        }
    }
}
