package com.chebdowski.resume.presentation

import com.chebdowski.core.exception.Failure

class PersonFailure {

    class PersonNotAvailable: Failure.FeatureFailure()
}