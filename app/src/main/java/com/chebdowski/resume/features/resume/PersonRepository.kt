package com.chebdowski.resume.features.resume

import com.chebdowski.resume.core.exception.Failure
import com.chebdowski.resume.core.functional.Either
import com.chebdowski.resume.core.networking.BaseRemoteRepository

interface PersonRepository {

    fun person(): Either<Failure, Person>

    class RemotePersonRepository(private val personApi: PersonApi) : BaseRemoteRepository(), PersonRepository {

        override fun person(): Either<Failure, Person> {
            return request(personApi.person(), { it.toPerson() }, PersonEntity.empty())
        }
    }
}