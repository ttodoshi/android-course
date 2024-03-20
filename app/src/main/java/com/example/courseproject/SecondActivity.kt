package com.example.courseproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.courseproject.databinding.ActivitySecondBinding
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {
    companion object {
        const val MAX_VALUE = "max_value"
        private const val RANDOM_VALUE = "random_value"
    }

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRandomNumber()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putCharSequence(RANDOM_VALUE, binding.random.text)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        binding.random.text = savedInstanceState.getCharSequence(RANDOM_VALUE)

        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun showRandomNumber() {
        val value = intent.getIntExtra(MAX_VALUE, 0)
        binding.random.text = generateRandomNumber(value).toString()
    }

    private fun generateRandomNumber(value: Int): Int {
        return Random.nextInt(value)
    }
}