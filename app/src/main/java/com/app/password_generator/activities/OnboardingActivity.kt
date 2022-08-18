package com.app.password_generator.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.password_generator.R
import com.app.password_generator.utils.BaseActivity
import com.app.password_generator.utils.SharedPref

class OnboardingActivity : BaseActivity() {
    private lateinit var sharedPref: SharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        sharedPref = SharedPref(applicationContext)
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedPref.setSession(true)
    }
}