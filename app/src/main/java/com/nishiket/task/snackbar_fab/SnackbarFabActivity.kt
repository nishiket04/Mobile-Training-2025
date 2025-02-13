package com.nishiket.task.snackbar_fab

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nishiket.task.R

class SnackbarFabActivity : AppCompatActivity() {
    private lateinit var addFab: FloatingActionButton
    private lateinit var likeFab: FloatingActionButton
    private lateinit var shareFab: FloatingActionButton

    // flag to check fab icon is open or close
    private var fabFlab: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar_fab)
        // function called to assign Ids to var
        findId()

        addFab.setOnClickListener {
            // if fab menu is closed then show all the icons
            if (!fabFlab) {
                addFab.setImageResource(R.drawable.close) // change the main fab icon from add to close
                likeFab.visibility = View.VISIBLE
                shareFab.visibility = View.VISIBLE
                fabFlab = true // flag change to open
                return@setOnClickListener // terminating the function
            }
            // if fab menu is open then hide all the icons
            addFab.setImageResource(R.drawable.baseline_add_24) // change the main fab icon from close to add
            likeFab.visibility = View.GONE
            shareFab.visibility = View.GONE
            fabFlab = false // flag change to close
        }
    }

    //Function to find ids of the views
    fun findId() {
        addFab = findViewById(R.id.addFab)
        likeFab = findViewById(R.id.likeFab)
        shareFab = findViewById(R.id.shareFab)
    }
}