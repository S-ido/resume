package com.chebdowski.resume.features.resume

import com.chebdowski.resume.core.exception.Failure
import com.chebdowski.resume.core.functional.Either

class PersonRepository {

    fun person(): Either<Failure, Person> {
        return Either.Right(Person("Piotr", "Chebdowski"))
    }
}