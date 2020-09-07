package com.example.sm_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import java.math.BigInteger

//@Suppress("NO_TAIL_CALLS_FOUND", "NON_TAIL_RECURSIVE_CALL")
@Suppress("NO_TAIL_CALLS_FOUND", "NON_TAIL_RECURSIVE_CALL")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val errorText = findViewById<TextView>(R.id.errorText)
        tailrec fun fact (n: Long): Long = when (n) {
            1.toLong() -> 1
            else -> n * fact(n - 1)
        }

        button.setOnClickListener {
            val inputNumber = findViewById<EditText>(R.id.inputNumber).text.toString().toLongOrNull()
            if (inputNumber !== null) {
                errorText.text = ""
                val factResult = fact(inputNumber)
                if (factResult > 0 ) {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("RESULT", factResult)
                    startActivity(intent)
                } else {
                    errorText.text = "Слишком большое число"
                }

            } else {
                errorText.text = "Некорректные данные!"
            }
        }
    }
}