package com.nishiket.task

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nishiket.task.activity.TaskOfActivity

class MainActivity : AppCompatActivity() {
    private lateinit var acitivity_task: Button
    private lateinit var layouts_task: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findIds()
        val activity: Intent = Intent(this, TaskOfActivity::class.java)
        acitivity_task.setOnClickListener{ view->
            startActivity(activity)
        }
    }

    fun findIds() {
        acitivity_task = findViewById(R.id.activity_task)
        layouts_task = findViewById(R.id.layout_task)
    }

}