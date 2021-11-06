package com.example.testdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn= findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val intent= Intent(this,DBList::class.java)
            startActivity(intent)
        }
    }
}