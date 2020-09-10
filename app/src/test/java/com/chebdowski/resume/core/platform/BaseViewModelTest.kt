package com.chebdowski.resume.core.platform

import androidx.lifecycle.MutableLiveData
import com.chebdowski.resume.AndroidTest
import com.chebdowski.resume.core.exception.Failure
import com.chebdowski.resume.core.exception.Failure.ServerError
import org.amshove.kluent.`should be instance of`
import org.junit.Test
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
class BaseViewModelTest : AndroidTest() {

    @Test
    fun `view model should update live data on error`() {
        val testViewModel = TestViewModel()

        testViewModel.handleError(ServerError)

        val failure = testViewModel.failure
        val error = testViewModel.failure.value

        failure `should be instance of` MutableLiveData::class.java
        error `should be instance of` ServerError::class.java
    }

    private class TestViewModel : BaseViewModel() {
        fun handleError(failure: Failure) = handleFailure(failure)
    }
}