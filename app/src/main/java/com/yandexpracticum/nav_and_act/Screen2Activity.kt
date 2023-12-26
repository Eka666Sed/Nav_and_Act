package com.yandexpracticum.nav_and_act

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Screen2Activity : AppCompatActivity(R.layout.activity_screen2) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("NAVEXAMPLE", "Screen2 -> onCreate")

        findViewById<TextView>(R.id.screen2Title).text = "Screen 2 [$this]"

        findViewById<Button>(R.id.screen2ButtonToScreen3).setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen2 -> Click on 'To screen 3'")
            openScreen3()
        }
    }

    private fun openScreen3() {
        val intent = Intent(this, Screen3Activity::class.java)

        this.startActivity(intent)
    }

}