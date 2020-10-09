package com.chebdowski.data

import retrofit2.Call
import retrofit2.http.GET

interface PersonApi {

    companion object {
        private const val PERSON = "person"
    }

    @GET(PERSON)
    fun person(): Call<PersonEntity>
}