package com.chebdowski.data

import com.chebdowski.domain.person.Person

data class PersonEntity(
    private val pictureUrl: String,
    private val firstName: String,
    private val lastName: String,
    private val position: String,
    private val position2: String,
    private val professionalSummary: String,
    private val phone: String,
    private val email: String,
    private val linkedIn: String,
    private val location: String,
    private val workExperience: WorkExperienceEntity,
    private val education: EducationEntity,
    private val skills: SkillsEntity
) {

    companion object {
        fun empty() = PersonEntity(
            "", "", "", "", "",
            "", "", "", "", "", WorkExperienceEntity.empty(),
            EducationEntity.empty(), SkillsEntity.empty()
        )
    }

    fun toPerson() = Person(
        pictureUrl, firstName, lastName, position, position2,
        professionalSummary, phone, email, linkedIn, location, workExperience.toWorkExperience(),
        education.toEducation(), skills.toSkills()
    )
}