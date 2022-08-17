package com.app.password_generator.utils

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class HideActionbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
    }
}