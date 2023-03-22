package com.example.geoquiz

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.trueButton.setOnClickListener {
            Toast.makeText(
                this, R.string.correct_toast, Toast.LENGTH_SHORT
            ).show()

        }
        binding.falseButton.setOnClickListener {
            val toast = Toast
                .makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT)
                .show()


        }
    }
}