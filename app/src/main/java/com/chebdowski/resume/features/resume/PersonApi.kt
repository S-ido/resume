package com.chebdowski.resume.features.resume

import retrofit2.Call
import retrofit2.http.GET

interface PersonApi {

    companion object {
        private const val PERSON = "323a2c129412a82481ef3e5f72c7c902/raw/c0b73218e18d88e4bcf5ed62748367978f4c458b/person"
    }

    @GET(PERSON)
    fun person(): Call<PersonEntity>
}