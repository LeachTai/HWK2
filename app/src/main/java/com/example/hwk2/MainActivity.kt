package com.example.hwk2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.util.Log

class MainActivity : AppCompatActivity() {
    private lateinit var noteEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        try {
            noteEditText = findViewById(R.id.noteEditText)
            saveButton = findViewById(R.id.saveButton)

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            saveButton.setOnClickListener {
                val note = noteEditText.text.toString().trim()
                if (note.isNotEmpty()) {
                    val intent = Intent(this, NoteSavedActivity::class.java)
                    intent.putExtra("NOTE_CONTENT", note)
                    startActivity(intent)
                    Log.d("MainActivity", "Jump to NoteSavedActivity with note: $note")
                } else {
                    Toast.makeText(this, "請輸入筆記內容", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Error: ${e.message}")
            Toast.makeText(this, "錯誤: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}