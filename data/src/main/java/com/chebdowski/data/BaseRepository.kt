package com.chebdowski.data

import com.chebdowski.core.exception.Failure
import com.chebdowski.core.exception.Failure.ServerError
import com.chebdowski.core.functional.Either
import com.chebdowski.core.functional.Either.Left
import com.chebdowski.core.functional.Either.Right
import retrofit2.Call

abstract class BaseRepository {

    protected fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Right(transform((response.body() ?: default)))
                false -> Left(ServerError)
            }
        } catch (exception: Throwable) {
            Left(ServerError)
        }
    }
}