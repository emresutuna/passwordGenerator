package com.app.password_generator

import android.os.Bundle
import com.app.password_generator.models.PasswordModel
import com.app.password_generator.utils.BaseActivity
import com.app.password_generator.utils.PasswordManager

class MainActivity : BaseActivity() {
    private var passwordManager = PasswordManager()
    private var passwordModel = PasswordModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun callPasswordGenerate() {
        passwordManager.generatePassword(
            true, true, true,
            true, 30
        )
    }
}