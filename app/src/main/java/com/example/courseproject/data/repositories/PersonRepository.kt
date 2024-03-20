package com.example.courseproject.data.repositories

import com.example.courseproject.domain.models.Person
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PersonRepository {
    @GET("/api/")
    fun fetchPeople(@Query("results") results: Int = 10): Call<PeopleResponse>
}

data class PeopleResponse(val results: List<Person>, val info: RequestInfo) {
    data class RequestInfo(val seed: String, val results: Int, val page: Int, val version: String)
}
