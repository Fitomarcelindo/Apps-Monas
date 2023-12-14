package by.marcel.figma_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import by.marcel.crud.data.AppDatabase
import by.marcel.figma_kotlin.adapter.UserAdapter
import by.marcel.crud.data.entity.User


private val <E> MutableList<E>.uid: Any
    get() {
        TODO("Not yet implemented")
    }

class Home_Page_Dosen : AppCompatActivity() {

    private var list = mutableListOf<User>()
    private lateinit var adapter: UserAdapter
    private lateinit var database: AppDatabase


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page_dosen)


        val class1  = findViewById<TextView>(R.id.class1)
        val class2  = findViewById<TextView>(R.id.class2)
        val class3  = findViewById<TextView>(R.id.class3)
        val class4  = findViewById<TextView>(R.id.class4)
        val output =  findViewById<TextView>(R.id.hslUserDosen)
        val btn    = findViewById<ImageView>(R.id.btn_profile)

        val hslUser = intent.getStringExtra("nama")

        output.text = "Good Morning $hslUser "

        database = AppDatabase.getInstance(applicationContext)
        adapter = UserAdapter(list)

        btn.setOnClickListener {
            val profile = Intent(this, Profile_Main_Dosen::class.java)
            startActivity(profile)
        }

        class1.setOnClickListener {
            val class1 = Intent(this, EditorActivity::class.java)
            intent.putExtra("id", list.uid)
            startActivity(intent)
            startActivity(class1)
        }

        class2.setOnClickListener {
            val class2 = Intent(this, EditorActivity::class.java)
            startActivity(class2)
        }

        class3.setOnClickListener {
            val class3 = Intent(this, EditorActivity::class.java)
            startActivity(class3)
        }

        class4.setOnClickListener {
            val class4 = Intent(this, EditorActivity::class.java)
            startActivity(class4)
        }


    }
}

private fun Intent.putExtra(s: String, uid: Any) {

}

