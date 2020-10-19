package com.chebdowski.data

import androidx.annotation.Keep
import com.chebdowski.domain.person.Skills

@Keep
data class SkillsEntity(
    val skills: List<String>
) {

    companion object {
        fun empty() = SkillsEntity(listOf(""))
    }

    fun toSkills() = Skills(skills)
}