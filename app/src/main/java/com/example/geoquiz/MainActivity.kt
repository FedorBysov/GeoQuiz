package com.example.geoquiz

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    private val questionBank = listOf(
        Question(R.string.question_africa, false),
        Question(R.string.question_asia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_americas, true),
        Question(R.string.question_australia, true)
    )

    private var currentIndex = 0
    private var rightAnswer = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.trueButton.setOnClickListener {
            checkAnswer(true)

        }
        binding.falseButton.setOnClickListener {
            checkAnswer(false)

        }

        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            answerResult(currentIndex)
            updateQuestion()
        }
        binding.backButton.setOnClickListener {
            if (currentIndex !=0){
                currentIndex -=1
                updateQuestion()
            }
        }
        updateQuestion()
    }

    private fun answerResult(question: Int) {
        if (question == 0) {
            Toast
                .makeText(this,
                    "Right answer: ${100 * rightAnswer / questionBank.size}",
                    Toast.LENGTH_SHORT)
                .show()
            rightAnswer = 0
            currentIndex = 0
        }

    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val currentAnswer = questionBank[currentIndex].answer
        if (userAnswer == currentAnswer){
            rightAnswer += 1
        }

        val messageResId =
            if (userAnswer == currentAnswer) {
                R.string.correct_toast
            } else {
                R.string.incorrect_toast
            }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }


}