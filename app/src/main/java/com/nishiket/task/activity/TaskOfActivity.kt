package com.nishiket.task.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nishiket.task.R
import com.nishiket.task.activity.data_pass.Task2_Activity_Get_Data_From_Back_Stack
import com.nishiket.task.activity.lifecycle.Task1_Activity

class TaskOfActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_of)
        findViewById<Button>(R.id.task1).setOnClickListener{
            val i:Intent = Intent(this, Task1_Activity::class.java)
            startActivity(i)
        }
        findViewById<Button>(R.id.task2).setOnClickListener{
            val i:Intent = Intent(this, Task2_Activity_Get_Data_From_Back_Stack::class.java)
            startActivity(i)
        }
    }
}