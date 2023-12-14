package by.marcel.figma_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<AppCompatImageView>(R.id.button)
        val btn2 = findViewById<AppCompatImageView>(R.id.button1)

        btn1.setOnClickListener {
            val intent = Intent(this, MainSign::class.java).apply {
            }
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val marcel1 = Intent(this, SignUp::class.java).apply {
            }
            startActivity(marcel1)
        }

    }
}