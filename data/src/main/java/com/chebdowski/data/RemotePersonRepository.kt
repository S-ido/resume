package com.chebdowski.data

import com.chebdowski.core.exception.Failure
import com.chebdowski.core.functional.Either
import com.chebdowski.domain.person.Person
import com.chebdowski.domain.person.PersonRepository

class RemotePersonRepository(private val personApi: PersonApi) : BaseRepository(), PersonRepository {

    override fun person(): Either<Failure, Person> {
        return request(personApi.person(), { it.toPerson() }, PersonEntity.empty())
    }
}