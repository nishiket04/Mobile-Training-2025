package com.nishiket.task.webview

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nishiket.task.R
import kotlin.io.encoding.Base64

class WebViewActivity : AppCompatActivity() {
    private lateinit var htmlWebView: WebView
    private lateinit var urlWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        // assign Id's
        findId()

        // url web view
        urlWebView.loadUrl("https://developer.android.com/develop/ui/views/layout/webapps/webview")
        urlWebView.settings.javaScriptEnabled = true

        // html web view
        val html = "<html><body><h1>Nishiket</h1></body></html>"
        htmlWebView.loadData(html, "text/html", "UTF-8")
    }

    // Function to find Id's of the view
    fun findId() {
        htmlWebView = findViewById(R.id.htmlWebView)
        urlWebView = findViewById(R.id.urlWebView)
    }
}