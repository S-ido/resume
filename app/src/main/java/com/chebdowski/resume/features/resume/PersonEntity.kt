package com.chebdowski.resume.features.resume

data class PersonEntity(private val firstName: String, private val lastName: String) {

    fun toPerson() = Person(firstName, lastName)
}