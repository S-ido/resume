package com.chebdowski.domain.person

data class Work(
    val position: String,
    val company: String,
    val date: String,
    val responsibilities: List<Responsibilities>
) {

    companion object {
        fun empty() = Work("", "", "", listOf(Responsibilities.empty()))
    }
}