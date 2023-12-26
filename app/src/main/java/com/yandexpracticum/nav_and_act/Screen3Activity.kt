package com.yandexpracticum.nav_and_act

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Screen3Activity : AppCompatActivity(R.layout.activity_screen3) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("NAVEXAMPLE", "Screen3 -> onCreate")

        findViewById<TextView>(R.id.screen3Title).text = "Screen 3 [$this]"

        findViewById<Button>(R.id.screen3ButtonToScreen1).setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'To screen 1'")
            openScreen1()
        }
        findViewById<Button>(R.id.screen3ButtonBack).setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'Back'")
            backToPreviousScreen()
        }

        findViewById<Button>(R.id.screen3ButtonToScreen3).setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'To screen 3'")
            openScreen3()
        }
    }

    private fun openScreen1() {
        val intent = Intent(this, Screen1Activity::class.java)

        this.startActivity(intent)
    }
    private fun backToPreviousScreen() {
        TODO("Пока не знаем, как реализовать")
    }

    private fun openScreen3() {
        val intent = Intent(this, Screen3Activity::class.java)

        this.startActivity(intent)
    }

}