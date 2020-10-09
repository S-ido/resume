package com.chebdowski.domain.person

data class Education(
    val degree: String,
    val school: String,
    val date: String,
    val notes: String
) {

    companion object {
        fun empty() = Education("", "", "", "")
    }
}