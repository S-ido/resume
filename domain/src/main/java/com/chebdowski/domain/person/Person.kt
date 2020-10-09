package com.chebdowski.domain.person

data class Person(
    val pictureUrl: String,
    val firstName: String,
    val lastName: String,
    val position: String,
    val secondPosition: String,
    val professionalSummary: String,
    val phone: String,
    val email: String,
    val linkedIn: String,
    val location: String,
    val workExperience: WorkExperience,
    val education: Education,
    val skills: Skills
) {

    companion object {
        fun empty() = Person(
            "", "", "", "", "",
            "", "", "", "", "", WorkExperience.empty(),
            Education.empty(), Skills.empty()
        )
    }
}