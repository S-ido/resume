package com.chebdowski.domain.person

data class WorkExperience(
    val experience: List<Work>
) {
    companion object {
        fun empty() = WorkExperience(listOf(Work.empty()))
    }
}