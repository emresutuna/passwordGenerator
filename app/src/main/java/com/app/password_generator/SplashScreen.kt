package com.app.password_generator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.app.password_generator.activities.OnboardingActivity
import com.app.password_generator.databinding.ActivitySplashScreenBinding
import com.app.password_generator.utils.BaseActivity
import com.app.password_generator.utils.SharedPref

@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var sharedPref: SharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initDataBinding(
            layoutInflater,
            R.layout.activity_splash_screen,
            container = null
        ) as ActivitySplashScreenBinding
        setContentView(binding.root)
        sharedPref = SharedPref(applicationContext)
        setFadeAnimation()

    }

    private fun setFadeAnimation() {
        binding.apply {
            splashLogo.alpha = 0f
            splashText.alpha = 0f
            splashText.animate().setDuration(1500).alpha(1f)
            splashLogo.animate().setDuration(1500).alpha(1f).withEndAction {
                isFirstTime(sharedPref.getSessionStatus())

            }
        }
    }

    private fun isFirstTime(session: Boolean) {
        if (!session) {
            goLandingPage()
            return
        }
        goMainActivity()
    }

    private fun goLandingPage() {
        val intent = Intent(this@SplashScreen, OnboardingActivity::class.java)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    private fun goMainActivity() {
        val intent = Intent(this@SplashScreen, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

}

