package com.nishiket.task.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.provider.OpenableColumns
import android.text.Html
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nishiket.task.R

class IntentActivity : AppCompatActivity() {
    private lateinit var image: ImageView
    private lateinit var btn_link: Button
    private lateinit var btn_call: Button
    private lateinit var btn_messgae: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        // to find ids of the view
        findId()

        // check its action intent
        when {
            intent?.action == Intent.ACTION_SEND -> {
                if ("audio/mpeg" == intent.type) {
                    lateinit var fileName: String
                    (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
                        Toast.makeText(this, it.lastPathSegment, Toast.LENGTH_LONG).show()
                    }

                } else if (intent.type?.startsWith("image/") == true) {
                    lateinit var fileName: String
                    (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
                        image.setImageURI(it)
                    }

                }
            }
        }

        btn_link.setOnClickListener {
            val link: Intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://developer.android.com/reference/androidx/media3/common/MimeTypes")
            )
            startActivity(link)
        }

        btn_call.setOnClickListener {
            val call: Intent = Intent(Intent.ACTION_DIAL)
            call.data = Uri.parse("tel:" + "7405105330")
            startActivity(call)
        }

        btn_messgae.setOnClickListener {
            val message: Intent = Intent(Intent.ACTION_SENDTO)
            message.putExtra(Intent.EXTRA_TEXT, "This is body text");
            message.data = Uri.parse("mailto:")
            message.putExtra(Intent.EXTRA_SUBJECT, "this is subject")
            message.putExtra(Intent.EXTRA_EMAIL, arrayOf("nishiket04@gmail.com"))
            startActivity(message)
        }


    }

    // Function to pass id
    fun findId() {
        image = findViewById(R.id.image)
        btn_link = findViewById(R.id.btn_link)
        btn_call = findViewById(R.id.btn_call)
        btn_messgae = findViewById(R.id.btn_messgae)
    }
}