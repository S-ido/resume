package com.chebdowski.resume.core.exception

/**
 * Base class for error handling.
 */
sealed class Failure {

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()
}