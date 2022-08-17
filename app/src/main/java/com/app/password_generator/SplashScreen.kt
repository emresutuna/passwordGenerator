package com.app.password_generator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.password_generator.databinding.ActivitySplashScreenBinding
import com.app.password_generator.utils.BaseActivity
import com.app.password_generator.utils.HideActionbarActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initDataBinding(
            layoutInflater,
            R.layout.activity_splash_screen,
            container = null
        ) as ActivitySplashScreenBinding
        setContentView(binding.root)
        setFadeAnimation()
    }

    private fun setFadeAnimation() {
        binding.apply {
            splashLogo.alpha = 0f
            splashLogo.alpha = 0f
            splashLogo.animate().setDuration(1500).alpha(1f).withEndAction {
                val intent = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }
    }
}

