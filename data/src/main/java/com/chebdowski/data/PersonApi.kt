package com.chebdowski.data

import retrofit2.Call
import retrofit2.http.GET

interface PersonApi {

    companion object {
        private const val PERSON = "2489eb2d780e02b74061551b7441567bf6aafdbc/person"
    }

    @GET(PERSON)
    fun person(): Call<PersonEntity>
}