package com.nishiket.task.viewmodel_livedata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TimerViewModel : ViewModel() {
    private val mutableLiveData: MutableLiveData<Int> =
        MutableLiveData() // mutable live data of Int
    private lateinit var scope: Job // Coroutine job
    var isTimerRunning: Boolean = false // flag of timer running
    var isFirstCall = true // flag of first call
    val liveData: LiveData<Int> // public Immutable live data
        get() {
            return mutableLiveData
        }

    fun startTime(time: Int) { // Function starts the timer
        var remainingTime = time // stores the remaining time
        scope = CoroutineScope(Dispatchers.Default).launch {
            isTimerRunning = true // change flag
            isFirstCall = false // change flag
            for (i in 1..time) {
                remainingTime--
                withContext(Dispatchers.Main) { // updates the live data
                    mutableLiveData.value = remainingTime
                }
                delay(999) // delay the loop
            }
        }
    }

    fun stopTime() {
        scope.cancel() // cancel the job
        isTimerRunning = false // change the flag
    }
}