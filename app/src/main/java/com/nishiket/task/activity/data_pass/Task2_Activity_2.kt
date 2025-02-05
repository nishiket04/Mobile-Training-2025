package com.nishiket.task.activity.data_pass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nishiket.task.R

class Task2_Activity_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task22)
        findViewById<Button>(R.id.go_to_first_activity).setOnClickListener{
            val i:Intent = Intent()
            i.putExtra("message","Message from second activity")
            setResult(Activity.RESULT_OK,i)
            finish()
        }
    }
}