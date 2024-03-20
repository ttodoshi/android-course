package com.example.courseproject.domain.viewmodels

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.example.courseproject.data.repositories.PersonRepository
import com.example.courseproject.domain.config.ApiConfig.retrofit
import com.example.courseproject.domain.models.Person
import retrofit2.awaitResponse


class PersonViewModel : ViewModel() {
    companion object {
        const val DEFAULT_FETCH_SIZE = 5
    }

    private val peopleRepository = retrofit.create(PersonRepository::class.java)
    val people = ObservableArrayList<Person>()

    suspend fun fetchPeople(fetchSize: Int = DEFAULT_FETCH_SIZE): Int {
        val response = peopleRepository.fetchPeople(fetchSize).awaitResponse()
        val result = response.body()?.results ?: emptyList()

        people.addAll(result)

        return result.size
    }
}