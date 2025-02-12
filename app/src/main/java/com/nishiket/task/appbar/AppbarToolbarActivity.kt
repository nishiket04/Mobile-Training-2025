package com.nishiket.task.appbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.NestedScrollView
import com.google.android.material.bottomappbar.BottomAppBar
import com.nishiket.task.R

class AppbarToolbarActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var nestedScroll: NestedScrollView
    private lateinit var bottomBar: BottomAppBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appbar_toolbar)
        //To find all id's
        findId()

        // To change fab icon position from center to bottom end.
        nestedScroll.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) { // Scrolling down
                bottomBar.postDelayed({
                    bottomBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                }, 100)
            } else if (scrollY < oldScrollY) { // Scrolling up
                bottomBar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        })
    }

    //Function to find all the ids of views
    fun findId() {
        toolbar = findViewById(R.id.toolBar)
        nestedScroll = findViewById(R.id.nestedScroll)
        bottomBar = findViewById(R.id.bottomBar)
    }
}