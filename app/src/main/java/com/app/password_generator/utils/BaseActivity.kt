package com.app.password_generator.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


open class BaseActivity : HideActionbarActivity(), UIStateController {
    override fun showProgress() {

    }

    override fun clicks() {

    }

    override fun hideProgress() {

    }

    override fun showErrorDialog(message: String) {

    }

    override fun showSuccessDialog(message: String) {

    }

    override fun setUIData() {

    }

    fun initDataBinding(
        inflater: LayoutInflater,
        layoutId: Int,
        container: ViewGroup?
    ): ViewDataBinding {
        return DataBindingUtil.inflate(inflater, layoutId, container, false)

    }

}