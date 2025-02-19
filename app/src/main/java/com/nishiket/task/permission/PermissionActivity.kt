package com.nishiket.task.permission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nishiket.task.R

class PermissionActivity : AppCompatActivity() {
    private lateinit var camera: TextView
    private lateinit var location: TextView
    private lateinit var gallery: TextView
    private final val REQUEST_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        // assigning views Id using this function
        findId()

        when {
            // check whether user granted permission before or not
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                gallery.text = "Granted"
                location.text = "Granted"
                camera.text = "Granted"
            }

            else -> { // if not then ask for permission
                requestPermissions(
                    arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA
                    ),
                    REQUEST_CODE
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CODE -> { // if its over requested permission
                location.text = if(grantResults[0] == PackageManager.PERMISSION_GRANTED) "Granted" else "Denied"
                gallery.text = if(grantResults[1] == PackageManager.PERMISSION_GRANTED) "Granted" else "Denied"
                camera.text = if(grantResults[2] == PackageManager.PERMISSION_GRANTED) "Granted" else "Denied"
            }
        }
    }

    // Function to find view Id's
    fun findId() {
        camera = findViewById(R.id.camera)
        location = findViewById(R.id.location)
        gallery = findViewById(R.id.gallery)
    }
}