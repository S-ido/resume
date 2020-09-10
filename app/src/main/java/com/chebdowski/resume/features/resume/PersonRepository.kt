package com.chebdowski.resume.features.resume

import com.chebdowski.resume.core.exception.Failure
import com.chebdowski.resume.core.functional.Either

interface PersonRepository {

    fun person(): Either<Failure, Person>

    class RemotePersonRepository() : PersonRepository {

        override fun person(): Either<Failure, Person> {
            return Either.Right(Person("Piotr", "Chebdowski"))
        }
    }
}