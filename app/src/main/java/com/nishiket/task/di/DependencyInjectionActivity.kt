package com.nishiket.task.di

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nishiket.task.R
import com.nishiket.task.di.viewmodel.viewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DependencyInjectionActivity : AppCompatActivity() {
    val viewModel: viewModel by viewModels() // view model instance
    @Inject lateinit var person:Person // Filed Inject
    private lateinit var basicHilt: Button
    private lateinit var constraintHilt: Button
    private lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dependency_injection)
        // assign Id using function
        findId()
        // live data observer
        viewModel.getLiveData().observe(this, {
            resultTextView.text = it
        })
        basicHilt.setOnClickListener {
            viewModel.getData() // request for data to viewModel
        }
        constraintHilt.setOnClickListener {
            resultTextView.text = person.toString()
        }

    }

    // Function to find Id's of the view
    private fun findId() {
        basicHilt = findViewById(R.id.basicHilt)
        constraintHilt = findViewById(R.id.constraintHilt)
        resultTextView = findViewById(R.id.resultTextView)
    }
}