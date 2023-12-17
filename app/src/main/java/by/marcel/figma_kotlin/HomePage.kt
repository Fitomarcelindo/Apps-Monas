package by.marcel.figma_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import by.marcel.figma_kotlin.data.DatabaseHelper

class HomePage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val output =  findViewById<TextView>(R.id.hslUser)
        val btnprofilemahasiswa = findViewById<ImageView>(R.id.btn_profilemahasiswa)
        val hslUser = intent.getStringExtra("nama")

        val dbHelper = DatabaseHelper(this)
        val lsUser = dbHelper.getUser()
        var i = 0

        for (user in lsUser) {
            i += 1
            val newRow = TextView(this)
            println(newRow)
            newRow.textAlignment = View.TEXT_ALIGNMENT_CENTER
            newRow.text = user.namaMK + " "+ user.kodeMK + " "+ user.ruangan + " "+ user.status
            newRow.setTextColor(Color.BLACK)
            newRow.gravity = Gravity.CENTER
            findViewById<LinearLayout>(R.id.kelas1).addView(newRow)

            val teamsButtonMhs = Button(this)
            teamsButtonMhs.text = "Join Teams Meeting"
            teamsButtonMhs.gravity = Gravity.CENTER
            teamsButtonMhs.setBackgroundColor(Color.WHITE)
            teamsButtonMhs.setPadding(20, 10, 20, 10)

            // Set margins for the button
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            layoutParams.setMargins(150, 10, 5, 10) // Adjust the margins as needed

            teamsButtonMhs.layoutParams = layoutParams

            findViewById<LinearLayout>(R.id.kelas1).addView(teamsButtonMhs)

            teamsButtonMhs.setOnClickListener {
                // Replace "your_teams_meeting_url" with the actual Teams meeting URL
                val teamsMeetingUrl = "https://teams.microsoft.com/v2/"

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(teamsMeetingUrl))
                startActivity(intent)
            }
        }

        output.text = "Good Morning $hslUser "

        btnprofilemahasiswa.setOnClickListener {
            val profile = Intent(this, Profile_Main_Mahasiswa::class.java)
            startActivity(profile)
        }


    }
}