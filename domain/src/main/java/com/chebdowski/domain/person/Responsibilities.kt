package com.chebdowski.domain.person

class Responsibilities(
    val responsibility: String,
    val achievements: List<String>
) {
    companion object {
        fun empty() = Responsibilities("", listOf(""))
    }
}