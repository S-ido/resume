package com.chebdowski.data

import androidx.annotation.Keep
import com.chebdowski.domain.person.Responsibilities

@Keep
data class ResponsibilitiesEntity(
    private val responsibility: String,
    private val achievements: List<String>
) {
    companion object {
        fun empty() = ResponsibilitiesEntity("", listOf(""))
    }

    fun toResponsibilities() = Responsibilities(responsibility, achievements)
}