package com.nishiket.task.workmanager

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.nishiket.task.R

class WorkManagerActivity : AppCompatActivity() {
    private lateinit var uploadImageButton: Button
    private lateinit var chargingWorkButton: Button
    private lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)
        // assign Id's
        findId()
        // work manager instance
        val workerRequest = WorkManager.getInstance(this)

        val imageWorker = OneTimeWorkRequest.from(ImageUploadWork::class.java)
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(true)
            .build()
        val chargingWorker = OneTimeWorkRequestBuilder<ImageUploadWork>().setConstraints(constraints).build()
        // set observer on work info
        workerRequest.getWorkInfoByIdLiveData(imageWorker.id).observe(this, {
            when (it?.state) {
                WorkInfo.State.SUCCEEDED -> resultTextView.text = "Succeeded"
                WorkInfo.State.RUNNING -> resultTextView.text = "Running"
                else -> resultTextView.text = "null"
            }
        })

        workerRequest.getWorkInfoByIdLiveData(chargingWorker.id).observe(this, {
            when (it?.state) {
                WorkInfo.State.SUCCEEDED -> resultTextView.text = "Succeeded"
                WorkInfo.State.RUNNING -> resultTextView.text = "Running"
                else -> resultTextView.text = "null"
            }
        })

        uploadImageButton.setOnClickListener {
            workerRequest.enqueue(imageWorker) // enqueue task on click
        }

        chargingWorkButton.setOnClickListener {
            workerRequest.enqueue(chargingWorker) // enqueue task on click
        }
    }

    // Function to find Id's of the view
    private fun findId() {
        uploadImageButton = findViewById(R.id.uploadImageButton)
        chargingWorkButton = findViewById(R.id.chargingWorkButton)
        resultTextView = findViewById(R.id.resultTextView)
    }
}