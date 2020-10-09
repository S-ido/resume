package com.chebdowski.data

import com.chebdowski.domain.person.Responsibilities
import com.chebdowski.domain.person.Work

class WorkEntity(
    private val position: String,
    private val company: String,
    private val date: String,
    private val responsibilities: List<ResponsibilitiesEntity>
) {
    companion object {
        fun empty() = WorkEntity("", "", "", listOf(ResponsibilitiesEntity.empty()))
    }

    fun toWork(): Work {
        val responsibilitiesList = mutableListOf<Responsibilities>()
        responsibilities.forEach { responsibilitiesEntity -> responsibilitiesList.add(responsibilitiesEntity.toResponsibilities()) }

        return Work(position, company, date, responsibilitiesList)
    }
}