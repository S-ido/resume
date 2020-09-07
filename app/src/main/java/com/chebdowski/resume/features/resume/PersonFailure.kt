package com.chebdowski.resume.features.resume

import com.chebdowski.resume.core.exception.Failure

class PersonFailure {

    class PersonNotAvailable: Failure.FeatureFailure()
}