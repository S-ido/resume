package com.chebdowski.interactors

import com.chebdowski.domain.person.Person
import com.chebdowski.domain.person.PersonRepository

class GetPerson(private val personRepository: PersonRepository) : UseCase<Person, UseCase.None>() {

    override suspend fun run(params: None) = personRepository.person()
}