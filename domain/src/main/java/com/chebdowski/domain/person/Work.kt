package com.chebdowski.domain.person

data class Work(
    val position: String,
    val company: String,
    val date: String,
    val responsibilities: Responsibilities
) {

    companion object {
        fun empty() = Work("", "", "", Responsibilities.empty())
    }
}