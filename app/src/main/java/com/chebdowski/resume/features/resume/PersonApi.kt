package com.chebdowski.resume.features.resume

import retrofit2.Call
import retrofit2.http.GET

interface PersonApi {

    companion object {
        private const val PERSON = "af276abd48110a2c2f3cb76c1c3028cdcb2984e7/person"
    }

    @GET(PERSON)
    fun person(): Call<PersonEntity>
}