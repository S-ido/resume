package com.chebdowski.resume.features.resume

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chebdowski.domain.person.Person
import com.chebdowski.interactors.GetPerson
import com.chebdowski.interactors.UseCase
import com.chebdowski.resume.core.platform.BaseViewModel
import org.koin.core.inject

class ResumeViewModel : BaseViewModel() {

    val getPerson: GetPerson by inject()

    private val _person: MutableLiveData<Person> = MutableLiveData()
    val person: LiveData<Person> = _person

    fun loadPerson() = getPerson(UseCase.None()) {
        it.either(::handleFailure, ::handlePerson)
    }

    private fun handlePerson(person: Person) {
        _person.value = person
    }
}