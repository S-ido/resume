package com.chebdowski.resume.core.exception

/**
 * Base class for error handling.
 */
sealed class Failure {

    object ServerError : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()
}