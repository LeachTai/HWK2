package com.example.hwk2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.util.Log
import android.widget.Toast

class NoteSavedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_note_saved)

            val savedNoteText = findViewById<TextView>(R.id.savedNoteText)
            val backButton = findViewById<Button>(R.id.backButton)

            val note = intent.getStringExtra("NOTE_CONTENT") ?: "無內容"
            savedNoteText.text = note
            Log.d("NoteSavedActivity", "Note displayed: $note")

            backButton.setOnClickListener {
                finish()
                Log.d("NoteSavedActivity", "Back button clicked")
            }
        } catch (e: Exception) {
            Log.e("NoteSavedActivity", "Error in onCreate: ${e.message}")
            Toast.makeText(this, "頁面錯誤: ${e.message}", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}