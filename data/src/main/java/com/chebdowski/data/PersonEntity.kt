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
    private val workExperience: WorkExperienceEntity
) {

    companion object {
        fun empty() = PersonEntity(
            "", "", "", "", "",
            "", "", "", "", "", WorkExperienceEntity.empty()
        )
    }

    fun toPerson() = Person(
        pictureUrl, firstName, lastName, position, position2,
        professionalSummary, phone, email, linkedIn, location, workExperience.toWorkExperience()
    )
}