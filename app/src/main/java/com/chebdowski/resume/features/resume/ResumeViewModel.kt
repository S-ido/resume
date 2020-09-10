package com.chebdowski.resume.features.resume

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chebdowski.resume.core.interactor.UseCase.None
import com.chebdowski.resume.core.platform.BaseViewModel
import org.koin.core.inject

class ResumeViewModel : BaseViewModel() {

    val getPerson: GetPerson by inject()

    private val _person: MutableLiveData<Person> = MutableLiveData()
    val person: LiveData<Person> = _person

    fun loadPerson() = getPerson(None()) {
        it.either(::handleFailure, ::handlePerson)
    }

    private fun handlePerson(person: Person) {
        _person.value = person
    }
}