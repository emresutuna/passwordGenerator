package com.app.password_generator.utils

import android.content.Context
import kotlin.system.exitProcess

open class SharedPref(contextParam: Context) {
    private var context: Context = contextParam
    private var token: String? = null
    private var session: Boolean? = null
    private var sessionStatus: Boolean = false


    private fun setSharedPreference(name: String, key: String?, value: String?) {
        val sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    private fun setSharedPreferenceBoolean(name: String, key: String?, value: Boolean?) {
        val sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value!!)
        editor.apply()
    }


    fun setSession(hasLogin: Boolean) {
        setSharedPreferenceBoolean(
            "sign", "sessionStatus", hasLogin
        )
    }


    fun clearUserPreference() {
        val preference = context.getSharedPreferences("sign", Context.MODE_PRIVATE)
        preference.edit().remove("sessionStatus").apply()
        token = null
        sessionStatus = false
    }

    fun setSessionStatus(sessionStatus: Boolean) {
        this.sessionStatus = sessionStatus
    }

    fun getSessionStatus(): Boolean {
        val sharedPref = context.getSharedPreferences("sign", Context.MODE_PRIVATE)
        sessionStatus = sharedPref.getBoolean("sessionStatus", false)
        return sessionStatus
    }

    fun exitApp() {
        clearUserPreference()
        exitProcess(1)
    }

}