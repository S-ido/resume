package com.chebdowski.resume.core.platform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chebdowski.resume.core.exception.Failure
import org.koin.core.KoinComponent

/**
 * Base ViewModel class.
 */
abstract class BaseViewModel : ViewModel(), KoinComponent {

    // Official recommendation on how to expose a mutable member as immutable in Kotlin.
    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    protected fun handleFailure(failure: Failure) {
        _failure.value = failure
    }
}