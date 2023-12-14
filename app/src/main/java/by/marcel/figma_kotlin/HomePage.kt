package by.marcel.figma_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class HomePage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val output =  findViewById<TextView>(R.id.hslUser)
        val btnprofilemahasiswa = findViewById<ImageView>(R.id.btn_profilemahasiswa)

        val hslUser = intent.getStringExtra("nama")

        output.text = "Good Morning $hslUser "

        btnprofilemahasiswa.setOnClickListener {
            val profile = Intent(this, Profile_Main_Mahasiswa::class.java)
            startActivity(profile)
        }
    }
}