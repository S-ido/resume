package com.chebdowski.resume.features.resume

data class Person(val firstName: String, val lastName: String, val position: String, val pictureUrl: String) {

    companion object {
        fun empty() = Person("", "", "", "")
    }
}