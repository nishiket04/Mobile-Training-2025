package com.nishiket.task

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nishiket.task.activity.TaskOfActivity
import com.nishiket.task.drawable.DrawableActivity
import com.nishiket.task.layouts.LayoutsActivity
import com.nishiket.task.viewpager.ViewPagerActivity

class MainActivity : AppCompatActivity() {
    private lateinit var acitivity_task: Button
    private lateinit var layouts_task: Button
    private lateinit var drawable_task: Button
    private lateinit var viewpager_task: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findIds()
        val activity: Intent = Intent(this, TaskOfActivity::class.java)
        acitivity_task.setOnClickListener{ view->
            startActivity(activity)
        }
        val layouts: Intent = Intent(this, LayoutsActivity::class.java)
        layouts_task.setOnClickListener{ view->
            startActivity(layouts)
        }
        val drawable: Intent = Intent(this, DrawableActivity::class.java)
        drawable_task.setOnClickListener{ view->
            startActivity(drawable)
        }
        val viewpager: Intent = Intent(this, ViewPagerActivity::class.java)
        viewpager_task.setOnClickListener{ view->
            startActivity(viewpager)
        }
    }

    fun findIds() {
        acitivity_task = findViewById(R.id.activity_task)
        layouts_task = findViewById(R.id.layout_task)
        drawable_task = findViewById(R.id.drawable_task)
        viewpager_task = findViewById(R.id.viewpager_task)
    }

}