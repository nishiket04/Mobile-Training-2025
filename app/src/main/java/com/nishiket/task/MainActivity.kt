package com.nishiket.task

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nishiket.task.activity.TaskOfActivity
import com.nishiket.task.dialog.DialogActivity
import com.nishiket.task.dimension.DimensionActivity
import com.nishiket.task.drawable.DrawableActivity
import com.nishiket.task.layouts.LayoutsActivity
import com.nishiket.task.viewpager.ViewPagerActivity

class MainActivity : AppCompatActivity() {
    private lateinit var acitivity_task: Button
    private lateinit var layouts_task: Button
    private lateinit var drawable_task: Button
    private lateinit var viewpager_task: Button
    private lateinit var dimension_task: Button
    private lateinit var dialog_task: Button
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
        val dimension: Intent = Intent(this, DimensionActivity::class.java)
        dimension_task.setOnClickListener{ view->
            startActivity(dimension)
        }
        val viewPager: Intent = Intent(this, ViewPagerActivity::class.java)
        viewpager_task.setOnClickListener{ view->
            startActivity(viewPager)
        }
        val dialog: Intent = Intent(this, DialogActivity::class.java)
        dialog_task.setOnClickListener{ view->
            startActivity(dialog)
        }
    }

    fun findIds() {
        acitivity_task = findViewById(R.id.activity_task)
        layouts_task = findViewById(R.id.layout_task)
        drawable_task = findViewById(R.id.drawable_task)
        viewpager_task = findViewById(R.id.viewpager_task)
        dimension_task = findViewById(R.id.dimension_task)
        dialog_task = findViewById(R.id.dialog_task)
    }

}