package by.marcel.figma_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import by.marcel.figma_kotlin.data.DatabaseHelper
import by.marcel.figma_kotlin.data.User



class EditorActivity : AppCompatActivity() {

    private lateinit var namaMK : EditText
    private lateinit var kodeMK  : EditText
    private lateinit var ruangan  : EditText
    private lateinit var status  : EditText
    private lateinit var btn    : Button
    private lateinit var btn2    : Button
//    private lateinit var database: AppDatabase

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        namaMK = findViewById<EditText>(R.id.namaMK)
        kodeMK = findViewById<EditText>(R.id.kodeMK)
        ruangan = findViewById<EditText>(R.id.ruangan)
        status = findViewById<EditText>(R.id.status)
        btn = findViewById<Button>(R.id.btn_save)
        btn2 = findViewById<Button>(R.id.btn_cancel)

//        database = AppDatabase.getInstance(applicationContext)
        val dbHelper = DatabaseHelper(this)
        val userid = intent.extras?.getString("id")

        val user = userid?.let { dbHelper.getUserId(it.toInt()) }
//        val getU
//        val intent = intent.extras
//
//        if (user != null) {
//            namaMK.setText(user.get(0))
//        }
//        if (intent!=null){
//            intent.getInt("id", 0)
            if (user != null) {
                namaMK.setText(user.get(1).trim())
            }
            if (user != null) {
                kodeMK.setText(user.get(2).trim())
            }
            if (user != null) {
                ruangan.setText(user.get(3).trim())
            }
            if (user != null) {
                status.setText(user.get(4).trim())
            }
//        }



        btn.setOnClickListener {
            if (namaMK.text.isNotEmpty() && kodeMK.text.isNotEmpty() && ruangan.text.isNotEmpty() && status.text.isNotEmpty()) {
                val updatedNamaMK = namaMK.text.toString()
                val updatedKodeMK = kodeMK.text.toString()
                val updatedRuangan = ruangan.text.toString()
                val updatedStatus = status.text.toString()

                val userUpdate = userid?.let { it1 -> User(it1.toInt(), updatedNamaMK, updatedKodeMK, updatedRuangan, updatedStatus) }
//
                val dbHelper = DatabaseHelper(this)
                if (userUpdate != null) {
                    dbHelper.updateData(userid.toString(), userUpdate)
                }

                Toast.makeText(this, "Data updated succes", Toast.LENGTH_SHORT).show()
//                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//                intent.removeExtra("id")
//                user?.clear()
//                if (user != null) {
//                    user.removeAll(0)
//                }
                startActivity(Intent(this,Home_Page_Dosen::class.java)) // Close the EditorActivity after updating the data
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }


        btn2.setOnClickListener {

            startActivity(Intent(this,Home_Page_Dosen::class.java))
            dbHelper.close()
        }
    }
}
