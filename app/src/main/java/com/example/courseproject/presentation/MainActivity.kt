package com.example.courseproject.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.courseproject.R
import com.example.courseproject.databinding.ActivityMainBinding
import com.example.courseproject.domain.viewmodels.PersonViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PersonAdapter
    private val personViewModel: PersonViewModel by lazy {
        ViewModelProvider(this)[PersonViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        adapter = PersonAdapter(
            personViewModel.people
        )

        with(binding) {
            peopleList.adapter = adapter
            refetchButton.setOnClickListener {
                fetchMorePeople()
            }
        }
    }

    private fun fetchMorePeople() {
        CoroutineScope(Dispatchers.Main).launch {
            var fetchedCount = 0
            async {
                fetchedCount = personViewModel.fetchPeople()
            }.await()
            async {
                adapter.notifyItemRangeInserted(
                    personViewModel.people.size - fetchedCount,
                    fetchedCount
                )
            }.await()
        }
    }
}