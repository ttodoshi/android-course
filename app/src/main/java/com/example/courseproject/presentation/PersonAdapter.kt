package com.example.courseproject.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.courseproject.domain.models.Person
import com.example.courseproject.databinding.ItemPersonBinding

class PersonAdapter(private val data: List<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    class PersonViewHolder(val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPersonBinding.inflate(inflater, parent, false)

        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: PersonViewHolder, position: Int) {
        viewHolder.binding.person = data[position]
    }

    override fun getItemCount() = data.size
}