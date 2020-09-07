package com.chebdowski.resume.core.functional

import com.chebdowski.resume.UnitTest
import com.chebdowski.resume.core.functional.Either.Left
import com.chebdowski.resume.core.functional.Either.Right
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.`should be instance of`
import org.amshove.kluent.`should be`
import org.junit.Test

class EitherTest : UnitTest() {

    @Test
    fun `Left should return correct type`() {
        val result = Left("left")

        result `should be instance of` Either::class.java
        result.isLeft `should be` true
        result.isRight `should be` false

        result.either(
            { left ->
                left `should be instance of` String::class.java
                left `should be equal to` "left"
            },
            {})
    }

    @Test
    fun `Right should return correct type`() {
        val result = Right("right")

        result `should be instance of` Either::class.java
        result.isRight `should be` true
        result.isLeft `should be` false

        result.either(
            {},
            { right ->
                right `should be instance of` String::class.java
                right `should be equal to` "right"
            })
    }
}