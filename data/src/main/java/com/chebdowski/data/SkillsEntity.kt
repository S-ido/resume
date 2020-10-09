package com.chebdowski.data

import com.chebdowski.domain.person.Skills

data class SkillsEntity(
    val skills: List<String>
) {

    companion object {
        fun empty() = SkillsEntity(listOf(""))
    }

    fun toSkills() = Skills(skills)
}