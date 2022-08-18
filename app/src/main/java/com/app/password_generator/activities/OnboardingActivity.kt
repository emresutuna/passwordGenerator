package com.app.password_generator.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.password_generator.MainActivity
import com.app.password_generator.R
import com.app.password_generator.adapters.OnboardingAdapter
import com.app.password_generator.databinding.ActivityOnboardingBinding
import com.app.password_generator.databinding.ActivitySplashScreenBinding
import com.app.password_generator.models.OnboardingModel
import com.app.password_generator.utils.BaseActivity
import com.app.password_generator.utils.SharedPref

class OnboardingActivity : BaseActivity() {
    private lateinit var sharedPref: SharedPref
    private lateinit var onboardingAdapter: OnboardingAdapter
    private lateinit var binding: ActivityOnboardingBinding
    private val onboardingItems: ArrayList<OnboardingModel> = arrayListOf(
        OnboardingModel(
            R.drawable.landing1,
            "Lorem ipsum",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in"
        ),
        OnboardingModel(
            R.drawable.landing2,
            "Lorem ipsum",
            " It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in"
        ),
        OnboardingModel(
            R.drawable.landing3,
            "Lorem ipsum",
            "Hadi Başlayalım"
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initDataBinding(
            layoutInflater,
            R.layout.activity_onboarding,
            container = null
        ) as ActivityOnboardingBinding
        setContentView(binding.root)
        sharedPref = SharedPref(applicationContext)
        clicks()
        setUIData()
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedPref.setSession(true)
    }

    private fun setList() {
        onboardingAdapter = OnboardingAdapter(applicationContext, onboardingItems)
        binding.viewpager.adapter = onboardingAdapter
    }

    override fun setUIData() {
        super.setUIData()
        setList()
    }

    override fun clicks() {
        super.clicks()
        binding.nextButton.setOnClickListener {
            if (binding.viewpager.currentItem + 1 < onboardingAdapter.itemCount) {
                binding.viewpager.currentItem += 1
                return@setOnClickListener
            }
            goMainPage()
        }
        binding.skipButton.setOnClickListener {
            goMainPage()
        }
    }

    private fun goMainPage() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }
}