package com.chebdowski.resume.features.resume

import com.chebdowski.core.exception.Failure

class PersonFailure {

    class PersonNotAvailable: Failure.FeatureFailure()
}