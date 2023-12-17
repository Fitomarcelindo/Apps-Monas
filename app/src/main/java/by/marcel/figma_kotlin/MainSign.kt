package by.marcel.figma_kotlin


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainSign : AppCompatActivity() {

    private lateinit var etusername : EditText
    private lateinit var etpassword : EditText
    private lateinit var btn : ImageView


    private val username = listOf("fitto2131001@itpln.ac.id", "Prof.Marcel", "azmi2131154@itpln.ac.id")
    private val password = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        etusername = findViewById(R.id.username)
        etpassword = findViewById(R.id.password)
        btn = findViewById(R.id.buttonIn)

        btn.setOnClickListener {
            val enteredUsername = etusername.text.toString()

            if (username.contains(enteredUsername) &&
                etpassword.text.toString().equals(password, ignoreCase = true)
            ) {
                val name = etusername.text.toString().trim()
                val destinationClass = when (enteredUsername) {
                    "fitto2131001@itpln.ac.id", "azmi2131154@itpln.ac.id" -> {
                        HomePage::class.java
                    }
                    "Prof.Marcel" -> {
                        Home_Page_Dosen::class.java
                    }
                    else -> {
                        return@setOnClickListener
                    }
                }

                val login = Intent(this@MainSign, destinationClass).apply {
                    putExtra("nama", name)
                }

                startActivity(login)
                Toast.makeText(this@MainSign, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainSign, "USERNAME OR PASSWORD IS WRONG", Toast.LENGTH_SHORT).show()
            }
        }
    }

    }
