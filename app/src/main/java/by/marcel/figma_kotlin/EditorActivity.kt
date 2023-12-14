package by.marcel.figma_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import by.marcel.crud.data.AppDatabase
import by.marcel.crud.data.entity.User

class EditorActivity : AppCompatActivity() {

    private lateinit var namaMK : EditText
    private lateinit var kodeMK  : EditText
    private lateinit var ruangan  : EditText
    private lateinit var status  : EditText
    private lateinit var btn    : Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        namaMK = findViewById<EditText>(R.id.namaMK)
        kodeMK = findViewById<EditText>(R.id.kodeMK)
        ruangan = findViewById<EditText>(R.id.ruangan)
        status = findViewById<EditText>(R.id.status)
        btn = findViewById<Button>(R.id.btn_save)

        database = AppDatabase.getInstance(applicationContext)

        val intent = intent.extras
        if (intent!=null){
            val id =  intent.getInt("id", 0)
            val user = database.UserDao().get(id)

            namaMK.setText(user.namaMK)
            kodeMK.setText(user.kodeMK)
            ruangan.setText(user.ruangan)
            status.setText(user.status)
        }

        btn.setOnClickListener {
            if (namaMK.text.isNotEmpty() && kodeMK.text.isNotEmpty() && ruangan.text.isNotEmpty() && status.text.isNotEmpty()){

                if (intent!=null){
                    database.UserDao().Update(
                        User(
                        intent.getInt("id",0),
                        namaMK.text.toString(),
                        kodeMK.text.toString(),
                        ruangan.text.toString(),
                        status.text.toString()
                    )
                    )
                }else {
                    database.UserDao().insertAll(
                        User(
                            null,
                            namaMK.text.toString(),
                            kodeMK.text.toString(),
                            ruangan.text.toString(),
                            status.text.toString()
                        )
                    )
                }
                finish()
            }else {
                Toast.makeText(
                    applicationContext,
                    "Please Field Data",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
