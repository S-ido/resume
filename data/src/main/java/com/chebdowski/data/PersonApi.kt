package com.chebdowski.data

import retrofit2.Call
import retrofit2.http.GET

interface PersonApi {

    companion object {
        private const val PERSON = "c66bcb70244c7f01ab0f95cb3d0006cabd9fdd52/person"
    }

    @GET(PERSON)
    fun person(): Call<PersonEntity>
}