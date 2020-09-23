package com.chebdowski.resume.features.resume

data class PersonEntity(private val firstName: String, private val lastName: String, private val pictureUrl: String) {

    companion object {
        fun empty() = PersonEntity("", "", "")
    }

    fun toPerson() = Person(firstName, lastName, pictureUrl)
}