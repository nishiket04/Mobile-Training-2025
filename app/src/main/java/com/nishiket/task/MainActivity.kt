package com.nishiket.task

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.nishiket.task.activity.TaskOfActivity
import com.nishiket.task.dialog.DialogActivity
import com.nishiket.task.appbar.AppbarToolbarActivity
import com.nishiket.task.dimension.DimensionActivity
import com.nishiket.task.drawable.DrawableActivity
import com.nishiket.task.fonts.FontsActivity
import com.nishiket.task.fragment.FragmentActivity
import com.nishiket.task.intent.IntentActivity
import com.nishiket.task.layouts.LayoutsActivity
import com.nishiket.task.map.MapsActivity
import com.nishiket.task.permission.PermissionActivity
import com.nishiket.task.recyclerview.RecyclerViewActivity
import com.nishiket.task.retrofit.RetofitActivity
import com.nishiket.task.service.ServiceActivity
import com.nishiket.task.sharedpreferences.LoginActivity
import com.nishiket.task.snackbar_fab.SnackbarFabActivity
import com.nishiket.task.viewpager.ViewPagerActivity
import com.nishiket.task.webview.WebViewActivity

class MainActivity : AppCompatActivity() {
    private lateinit var acitivity_task: Button
    private lateinit var layouts_task: Button
    private lateinit var drawable_task: Button
    private lateinit var viewpager_task: Button
    private lateinit var dimension_task: Button
    private lateinit var dialog_task: Button
    private lateinit var fonts_task: Button
    private lateinit var appbar_toolbar_task: Button
    private lateinit var snackbar_fab_task: Button
    private lateinit var fragment_task: Button
    private lateinit var recyclerview_task: Button
    private lateinit var intent_task: Button
    private lateinit var permissions_task: Button
    private lateinit var sharedPreferences_task: Button
    private lateinit var webview_task: Button
    private lateinit var map_task: Button
    private lateinit var retrofit_task: Button
    private lateinit var service_task: Button
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
        val appBar: Intent = Intent(this, AppbarToolbarActivity::class.java)
        appbar_toolbar_task.setOnClickListener { view->
            startActivity(appBar)
        }
        val fonts: Intent = Intent(this, FontsActivity::class.java)
        fonts_task.setOnClickListener{ view->
            startActivity(fonts)
        }
        val snackBarFab: Intent = Intent(this, SnackbarFabActivity::class.java)
        snackbar_fab_task.setOnClickListener{ view->
            startActivity(snackBarFab)
        }
        val dialog: Intent = Intent(this, DialogActivity::class.java)
        dialog_task.setOnClickListener{ view->
            startActivity(dialog)
        }
        val fragment: Intent = Intent(this, FragmentActivity::class.java)
        fragment_task.setOnClickListener{ view->
            startActivity(fragment)
        }
        val recyclerview: Intent = Intent(this, RecyclerViewActivity::class.java)
        recyclerview_task.setOnClickListener{ view->
            startActivity(recyclerview)
        }
        val intent: Intent = Intent(this, IntentActivity::class.java)
        intent_task.setOnClickListener{ view->
            startActivity(intent)
        }
        val permission: Intent = Intent(this, PermissionActivity::class.java)
        permissions_task.setOnClickListener{ view->
            startActivity(permission)
        }
        val sharedpreferences: Intent = Intent(this, LoginActivity::class.java)
        sharedPreferences_task.setOnClickListener{ view->
            startActivity(sharedpreferences)
        }
        val webView: Intent = Intent(this, WebViewActivity::class.java)
        webview_task.setOnClickListener{ view->
            startActivity(webView)
        }
        val map: Intent = Intent(this, MapsActivity::class.java)
        map_task.setOnClickListener{ view->
            startActivity(map)
        }
        val retrofit: Intent = Intent(this, RetofitActivity::class.java)
        retrofit_task.setOnClickListener{ view->
            startActivity(retrofit)
        }
        val service: Intent = Intent(this, ServiceActivity::class.java)
        service_task.setOnClickListener{ view->
            startActivity(service)
        }
    }

    fun findIds() {
        acitivity_task = findViewById(R.id.activity_task)
        layouts_task = findViewById(R.id.layout_task)
        drawable_task = findViewById(R.id.drawable_task)
        viewpager_task = findViewById(R.id.viewpager_task)
        dimension_task = findViewById(R.id.dimension_task)
        fonts_task = findViewById(R.id.fonts_task)
        appbar_toolbar_task = findViewById(R.id.appbar_toolbar_task)
        snackbar_fab_task = findViewById(R.id.Snackbar_fab_task)
        dialog_task = findViewById(R.id.dialog_task)
        fragment_task = findViewById(R.id.fragment_task)
        recyclerview_task = findViewById(R.id.recyclerview_task)
        intent_task = findViewById(R.id.intent_task)
        permissions_task = findViewById(R.id.permissions_task)
        sharedPreferences_task = findViewById(R.id.sharedPreferences_task)
        webview_task = findViewById(R.id.webview_task)
        map_task = findViewById(R.id.map_task)
        retrofit_task = findViewById(R.id.retrofit_task)
        service_task = findViewById(R.id.service_task)
    }

}