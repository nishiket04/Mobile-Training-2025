package com.nishiket.task.viewmodel_livedata

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nishiket.task.R
import com.nishiket.task.viewmodel_livedata.viewmodel.TimerViewModel

class ViewModelActivity : AppCompatActivity() {
    private lateinit var edt_time: EditText
    private lateinit var btn_start: Button
    private lateinit var btn_stop: Button
    private lateinit var txt_remainingTime: TextView
    private lateinit var timerViewModel: TimerViewModel
    private var lastTime: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        // assign Id
        findId()
        //gets the viewModel Instance
        timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        // set the observer on the livedata
        timerViewModel.liveData.observe(this, {
            txt_remainingTime.text = it.toString()
            lastTime = it
        })
        btn_stop.isEnabled = false // stop is disabled
        if (timerViewModel.isTimerRunning) { // check whether timer is already started or not
            //change the UI
            btn_start.isEnabled = false
            btn_stop.isEnabled = true
        }
        btn_start.setOnClickListener {
            if (timerViewModel.isFirstCall) { // if this first start time call then take input form edit text
                if (edt_time.text.toString().isEmpty()) {
                    Toast.makeText(
                        this@ViewModelActivity,
                        "Enter some number to timer to be start",
                        Toast.LENGTH_LONG
                    ).show()
                    return@setOnClickListener
                }
                val enteredTime = edt_time.text.toString().toInt()
                timerViewModel.startTime(enteredTime) // starts the timer
            } else { // if this is not first call
                timerViewModel.startTime(lastTime) // starts the timer form stopped time
            }
            // change the UI
            btn_start.isEnabled = false
            btn_stop.isEnabled = true

        }

        btn_stop.setOnClickListener {
            btn_start.isEnabled = true
            btn_stop.isEnabled = false
            timerViewModel.stopTime() // stops the time
        }
    }


    // Function to find Id's of the view
    fun findId() {
        edt_time = findViewById(R.id.edt_time)
        btn_start = findViewById(R.id.btn_start)
        btn_stop = findViewById(R.id.btn_stop)
        txt_remainingTime = findViewById(R.id.txt_remainingTime)
    }
}