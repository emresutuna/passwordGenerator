package com.app.password_generator.utils

interface UIStateController {
    fun showProgress()
    fun clicks()
    fun hideProgress()
    fun showErrorDialog(message: String)
    fun showSuccessDialog(message: String)
    fun setUIData()

}