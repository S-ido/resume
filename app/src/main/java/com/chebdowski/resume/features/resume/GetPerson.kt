package com.chebdowski.resume.features.resume

import com.chebdowski.resume.core.interactor.UseCase
import com.chebdowski.resume.core.interactor.UseCase.None
import org.koin.core.KoinComponent
import org.koin.core.inject

class GetPerson : UseCase<Person, None>(), KoinComponent {

    val personRepository: PersonRepository by inject()

    override suspend fun run(params: None) = personRepository.person()
}