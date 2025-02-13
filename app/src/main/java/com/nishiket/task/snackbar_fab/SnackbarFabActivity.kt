package com.nishiket.task.snackbar_fab

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.nishiket.task.R

class SnackbarFabActivity : AppCompatActivity() {
    private lateinit var addFab: FloatingActionButton
    private lateinit var likeFab: FloatingActionButton
    private lateinit var shareFab: FloatingActionButton
    private lateinit var animatedSnackBar: Button
    private lateinit var actionSnackBar: Button
    private lateinit var anchorSnackBar: Button

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

        // slide Animated SnackBar
        animatedSnackBar.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.main),
                "This is animated snackBar",
                Snackbar.LENGTH_LONG
            ).setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE)
                .setBackgroundTint(resources.getColor(R.color.teal_200)).show()
        }

        // action button snackBar
        actionSnackBar.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.main),
                "This is snackBar with action button",
                Snackbar.LENGTH_LONG
            ).setAction("Close", {
                Snackbar.make(
                    findViewById(R.id.main),
                    "SnackBar is closed",
                    Snackbar.LENGTH_SHORT
                ).show()
            }).setTextColor(resources.getColor(R.color.teal_700))
                .setBackgroundTint(resources.getColor(R.color.medium_black)).show()
        }

        // anchor to addFab snackBar
        anchorSnackBar.setOnClickListener {
            Snackbar.make(
                findViewById(R.id.main),
                "This is snackBar with anchor to fab",
                Snackbar.LENGTH_LONG
            ).setAnchorView(R.id.addFab).show()
        }
    }

    //Function to find ids of the views
    fun findId() {
        addFab = findViewById(R.id.addFab)
        likeFab = findViewById(R.id.likeFab)
        shareFab = findViewById(R.id.shareFab)
        animatedSnackBar = findViewById(R.id.animatedSnackBar)
        actionSnackBar = findViewById(R.id.actionSnackBar)
        anchorSnackBar = findViewById(R.id.anchorSnackBar)
    }
}