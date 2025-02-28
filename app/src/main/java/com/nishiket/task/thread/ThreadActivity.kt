package com.nishiket.task.thread

import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nishiket.task.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ThreadActivity : AppCompatActivity() {
    private lateinit var addNumberButton: Button
    private lateinit var operationButton: Button
    private lateinit var asyncButton: Button
    private lateinit var complexOpButton: Button
    private lateinit var resultTextView: TextView
    private var flag = false // flag to check thread execution
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        // assigns Id'S
        findId()

        addNumberButton.setOnClickListener {
            Thread {
                val sum = 2 + 2
                Thread.sleep(5000) // sleep to mimic long work
                runOnUiThread {
                    resultTextView.text = sum.toString()
                }
            }.start()
            resultTextView.text = "Wait For Calculation"
        }

        operationButton.setOnClickListener {
            resultTextView.text = "Wait For Calculation"
            var num = 100
            val divideThread = Thread {
                num /= 2
                Thread.sleep(5000)
                flag = true
            }
            val incrementThread = Thread {
                num++
                Handler(Looper.getMainLooper()).post {
                    resultTextView.text = num.toString()
                }
            }
            divideThread.start() // start first thread
            if (flag) { // check if first thread is completed
                incrementThread.start() // start second thread
            }
        }

        asyncButton.setOnClickListener {
            AsyncOperation().execute() // start AsyncTask
        }

        complexOpButton.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                printPrimeNumbers(1000000) // print prime number form 1 to 100000
            }
        }

    }

    // Function to find Id's of the view
    private fun findId() {
        addNumberButton = findViewById(R.id.addNumberButton)
        operationButton = findViewById(R.id.operationButton)
        asyncButton = findViewById(R.id.asyncButton)
        complexOpButton = findViewById(R.id.complexOpButton)
        resultTextView = findViewById(R.id.resultTextView)
    }

    // Function to print prime number
    fun printPrimeNumbers(input: Int) {
        var low = 1
        while (low < input) {
            if (primeNumber(low))
                CoroutineScope(Dispatchers.Main).launch {
                    resultTextView.text = low.toString()
                }
            ++low
        }
    }

    // Function to check number is prime or not
    fun primeNumber(num: Int): Boolean {
        var flag = true
        for (i in 2..num / 2) {
            if (num % i == 0) {
                flag = false
                break
            }
        }
        return flag
    }

    // Async Task class
    inner class AsyncOperation : AsyncTask<Unit, Int, Unit>() {
        override fun doInBackground(vararg p0: Unit?) {
            for (i in 1..100) {
                for (j in 1..100)
                    publishProgress(i)
            }
        }

        override fun onProgressUpdate(vararg values: Int?) {
            if (values[0] == 10) {
                cancel(false)
            }
            resultTextView.text = values[0].toString()
        }

        override fun onPostExecute(result: Unit?) {
            Toast.makeText(applicationContext, "Progress is completed", Toast.LENGTH_LONG).show()
        }

        override fun onCancelled(result: Unit?) {
            Toast.makeText(applicationContext, "Operation is canceled", Toast.LENGTH_LONG).show()
        }

    }
}