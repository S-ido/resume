package com.chebdowski.data

import com.chebdowski.domain.person.Responsibilities

data class ResponsibilitiesEntity(
    private val responsibility: String,
    private val achievements: List<String>
) {
    companion object {
        fun empty() = ResponsibilitiesEntity("", listOf(""))
    }

    fun toResponsibilities() = Responsibilities(responsibility, achievements)
}