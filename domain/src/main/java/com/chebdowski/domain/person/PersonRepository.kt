package com.chebdowski.domain.person

import com.chebdowski.core.exception.Failure
import com.chebdowski.core.functional.Either

interface PersonRepository {

    fun person(): Either<Failure, Person>
}