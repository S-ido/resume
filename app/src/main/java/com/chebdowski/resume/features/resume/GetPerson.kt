package com.chebdowski.resume.features.resume

import com.chebdowski.resume.core.interactor.UseCase
import com.chebdowski.resume.core.interactor.UseCase.None

class GetPerson(val personRepository: PersonRepository) : UseCase<Person, None>() {

    override suspend fun run(params: None) = personRepository.person()
}