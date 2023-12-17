package by.marcel.figma_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SignUp : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btnpln = findViewById<ImageView>(R.id.btn_itpln)

        btnpln.setOnClickListener {
            val pln = Intent(this, MainSign::class.java)
            startActivity(pln)
        }
    }
}