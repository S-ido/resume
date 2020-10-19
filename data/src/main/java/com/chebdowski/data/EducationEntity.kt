package com.chebdowski.data

import androidx.annotation.Keep
import com.chebdowski.domain.person.Education

@Keep
data class EducationEntity(
    val degree: String,
    val school: String,
    val date: String,
    val notes: String
) {

    companion object {
        fun empty() = EducationEntity("", "", "", "")
    }

    fun toEducation() = Education(degree, school, date, notes)
}