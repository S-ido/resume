package com.chebdowski.resume.core.interactor

import com.chebdowski.resume.AndroidTest
import com.chebdowski.resume.core.exception.Failure
import com.chebdowski.resume.core.functional.Either
import com.chebdowski.resume.core.functional.Either.Right
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be equal to`
import org.junit.Test
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
class UseCaseTest : AndroidTest() {

    private val testParam = "TestParam"
    private val testTypeParam = "TestTypeParam"
    private val useCase = TestUseCase()

    @Test
    fun `Use case should return 'Either' of use case type`() {
        val params = TestParams(testParam)
        val result = runBlocking { useCase.run(params) }

        result `should be equal to` Right(TestType(testTypeParam))
    }

    @Test
    fun `Use case should return correct data`() {
        var result: Either<Failure, TestType>? = null
        val params = TestParams(testParam)
        val onResult = { testResult: Either<Failure, TestType> -> result = testResult }

        runBlocking { useCase(params, onResult) }

        result `should be equal to` Right(TestType(testTypeParam))
    }

    data class TestType(val name: String)
    data class TestParams(val name: String)

    private inner class TestUseCase : UseCase<TestType, TestParams>() {
        override suspend fun run(params: TestParams) = Right(TestType(testTypeParam))
    }
}