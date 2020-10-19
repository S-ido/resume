package com.chebdowski.data

import androidx.annotation.Keep
import com.chebdowski.domain.person.Work
import com.chebdowski.domain.person.WorkExperience

@Keep
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