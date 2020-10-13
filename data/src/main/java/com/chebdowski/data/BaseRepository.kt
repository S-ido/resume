package com.chebdowski.data

import com.chebdowski.core.exception.Failure
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
                false -> Left(getError(response.code()))
            }
        } catch (exception: Throwable) {
            Left(Failure.RequestError)
        }
    }

    private fun getError(code: Int): Failure =
        when (code) {
            400 -> Failure.BadRequest
            401 -> Failure.Unauthorized
            403 -> Failure.Forbidden
            404 -> Failure.NotFound
            408 -> Failure.RequestTimeout
            in 500..599 -> Failure.ServerError
            else -> {
                val error = Failure.UnhandledError
                error.errorCode = code
                error
            }
        }
}