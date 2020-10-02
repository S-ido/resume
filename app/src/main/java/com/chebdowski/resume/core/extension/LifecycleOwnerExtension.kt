package com.chebdowski.resume.core.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.chebdowski.core.exception.Failure

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}

fun <L : LiveData<Failure>> LifecycleOwner.failure(liveData: L, body: (Failure?) -> Unit) {
    liveData.observe(this, Observer(body))
}

@Composable
fun <T : Any, L : LiveData<T>> observeAsState(liveData: L): T? {
    return liveData.observeAsState().value
}

@Composable
fun <T : Any, L : LiveData<T>> failureAsState(liveData: L): T? {
    return liveData.observeAsState().value
}