package com.chebdowski.data

import com.chebdowski.domain.person.Work

class WorkEntity(
    private val position: String,
    private val company: String,
    private val date: String,
    private val responsibilities: ResponsibilitiesEntity
) {
    companion object {
        fun empty() = WorkEntity("", "", "", ResponsibilitiesEntity.empty())
    }

    fun toWork() = Work(
        position, company, date, responsibilities.toResponsibilities()
    )
}