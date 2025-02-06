package com.nishiket.task.activity.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Task1_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Life_Cycle", "onCreate: " + "The on Create is called")

    }
    override fun onStart() {
        Log.d("Life_Cycle", "onStart: " + "The on start is called")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Life_Cycle", "onResume: " + "The on Resume is called")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Life_Cycle", "onPause: " + "The on Pause is called")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Life_Cycle", "onStop: " + "The on Stop is called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("Life_Cycle", "onDestroy: " + "The on Destroy is called")
        super.onDestroy()
    }

    override fun onRestart() {
        Log.d("Life_Cycle", "onRestart: " + "The on Restart is called")
        super.onRestart()
    }
}