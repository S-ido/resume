package com.chebdowski.resume.features.resume

data class Person(
    val pictureUrl: String,
    val firstName: String,
    val lastName: String,
    val position: String,
    val secondPosition: String,
    val professionalSummary: String
) {

    companion object {
        fun empty() = Person("", "", "", "", "", "")
    }
}