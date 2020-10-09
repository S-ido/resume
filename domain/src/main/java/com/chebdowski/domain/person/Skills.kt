package com.chebdowski.domain.person

data class Skills(
    val skills: List<String>
) {

    companion object {
        fun empty() = Skills(listOf(""))
    }
}