package by.marcel.figma_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import by.marcel.figma_kotlin.data.DatabaseHelper


//private val <E> MutableList<E>.uid: Any
//    get() {
//        TODO("Not yet implemented")
//    }

//private fun TextView.text(s: String): String {
//    return s
//}

class Home_Page_Dosen() : AppCompatActivity(), Parcelable {

//    private var list = mutableListOf<User>()
//    private lateinit var adapter: UserAdapter
//    private lateinit var database: AppDatabase


    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Home_Page_Dosen> {
        override fun createFromParcel(parcel: Parcel): Home_Page_Dosen {
            return Home_Page_Dosen(parcel)
        }

        override fun newArray(size: Int): Array<Home_Page_Dosen?> {
            return arrayOfNulls(size)
        }
    }

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page_dosen)

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
            findViewById<LinearLayout>(R.id.kelas).addView(newRow)

            val teamsButton = Button(this)
            teamsButton.text = "Join Teams Meeting"
            teamsButton.gravity = Gravity.CENTER
            teamsButton.setBackgroundColor(Color.WHITE)
            teamsButton.setPadding(20, 0, 20, 10)

            // Set margins for the button
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            layoutParams.setMargins(150, 10, 5, 10) // Adjust the margins as needed

            teamsButton.layoutParams = layoutParams

            findViewById<LinearLayout>(R.id.kelas).addView(teamsButton)

            teamsButton.setOnClickListener {
                // Replace "your_teams_meeting_url" with the actual Teams meeting URL
                val teamsMeetingUrl = "https://teams.microsoft.com/v2/"

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(teamsMeetingUrl))
                startActivity(intent)
            }

            newRow.setOnClickListener {
                val intent = Intent(this,EditorActivity::class.java).apply {
                    putExtra("id",user.uid.toString())
                }
//                finish()
                startActivity(intent)

            }

        }

// Setel nilai TextView menggunakan data dari database
//        val textView = findViewById<TextView>(R.id.class1)

        val output = findViewById<TextView>(R.id.hslUserDosen)
        val btn = findViewById<ImageView>(R.id.btn_profile)
        val btn_img =  findViewById<ImageView>(R.id.btn_img)

        val hslUser = intent.getStringExtra("nama")

        output.text = "Good Morning $hslUser "

        btn.setOnClickListener {
            val profile = Intent(this, Profile_Main_Dosen::class.java)
            startActivity(profile)
        }

        btn_img.setOnClickListener {
            val img = Intent(this, Profile_Main_Dosen::class.java)
            startActivity(img)
        }
    }

}

