package com.yandexpracticum.nav_and_act

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback

class Screen3Activity : AppCompatActivity(R.layout.activity_screen3) {

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            showWarningToast()
            disableCallback()
        }
    }

    private val handler = Handler(Looper.getMainLooper())

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

        onBackPressedDispatcher.addCallback(this, callback)

        findViewById<Button>(R.id.screen3ButtonToScreen1WithClear).setOnClickListener {
            Log.d("NAVEXAMPLE", "Screen3 -> Click on 'Back to Screen 1'")
            backToScreen1()
        }
    }

    // Показываем Toast с предупреждением
    private fun showWarningToast() {
        Toast.makeText(this, "Нажмите ещё раз, чтобы перейти на предыдущий экран", Toast.LENGTH_SHORT).show()
    }

    private fun disableCallback() {
        // Отключаем callback
        callback.isEnabled = false

        // И через две секунды включаем его обратно
        handler.postDelayed({
            callback.isEnabled = true
        }, 2000L)
    }

    private fun openScreen1() {
        val intent = Intent(this, Screen1Activity::class.java)

        this.startActivity(intent)
    }

    private fun backToPreviousScreen() {
        this.onBackPressedDispatcher.onBackPressed()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.d("NAVEXAMPLE", "Screen3 -> onNewIntent")
    }

    private fun openScreen3() {
        val intent = Intent(this, Screen3Activity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP

        this.startActivity(intent)
    }

    private fun backToScreen1() {
        val intent = Intent(this, Screen1Activity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

        this.startActivity(intent)
    }



}