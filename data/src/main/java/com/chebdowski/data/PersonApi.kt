package com.chebdowski.data

import retrofit2.Call
import retrofit2.http.GET

interface PersonApi {

    companion object {
        private const val PERSON = "7f1349940ec831f81871ae878f80033846ec20df/person"
    }

    @GET(PERSON)
    fun person(): Call<PersonEntity>
}