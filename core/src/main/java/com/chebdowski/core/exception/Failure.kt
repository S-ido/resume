package com.chebdowski.core.exception

/**
 * Base class for error handling.
 */
sealed class Failure {

    object BadRequest : Failure()
    object Unauthorized : Failure()
    object Forbidden : Failure()
    object NotFound : Failure()
    object RequestTimeout : Failure()
    object ServerError : Failure()
    object UnhandledError : Failure() { var errorCode: Int = -1 }
    object RequestError : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()
}