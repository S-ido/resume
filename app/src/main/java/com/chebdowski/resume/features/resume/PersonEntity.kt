package com.chebdowski.resume.features.resume

data class PersonEntity(
    private val pictureUrl: String,
    private val firstName: String,
    private val lastName: String,
    private val position: String,
    private val position2: String,
    private val professionalSummary: String
) {

    companion object {
        fun empty() = PersonEntity("", "", "", "", "", "")
    }

    fun toPerson() = Person(pictureUrl, firstName, lastName, position, position2, professionalSummary)
}