package com.chebdowski.interactors

import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Base class for unit tests. Inherit from it to create test cases which DO NOT contain android
 * framework dependencies or components.
 */
@RunWith(MockitoJUnitRunner::class)
abstract class UnitTest {

    // The purpose of this annotation is to show that I am aware it can be the reason of memory links
    @Suppress("LeakingThis")
    @Rule
    @JvmField
    val injectMocks = InjectMocksRule.create(this@UnitTest)
}
