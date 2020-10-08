package com.chebdowski.data

import com.chebdowski.domain.person.Work
import com.chebdowski.domain.person.WorkExperience

class WorkExperienceEntity(
    private val experience: List<WorkEntity>
) {
    companion object {
        fun empty() = WorkExperienceEntity(listOf(WorkEntity.empty()))
    }

    fun toWorkExperience(): WorkExperience {
        val experienceList = mutableListOf<Work>()
        experience.forEach { workEntity -> experienceList.add(workEntity.toWork()) }
        return WorkExperience(experienceList)
    }
}