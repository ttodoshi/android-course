package com.example.courseproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.courseproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            toastButton.setOnClickListener {
                showToast()
            }
            countButton.setOnClickListener {
                count()
            }
            randomButton.setOnClickListener {
                randomNumber()
            }
        }
    }

    private fun showToast() {
        Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show()
    }

    private fun count() {
        with(binding.counter) {
            var value = text.toString().toInt()
            text = (++value).toString()
        }
    }

    private fun randomNumber() {
        val randomIntent = Intent(this, SecondActivity::class.java)
        randomIntent.putExtra(SecondActivity.MAX_VALUE, binding.counter.text.toString().toInt())
        startActivity(randomIntent)
    }
}