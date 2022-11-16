package com.app.password_generator.models

data class PasswordModel(
    var isWithLetters: Boolean = false,
    var isWithUppercase: Boolean = false,
    var isWithNumbers: Boolean = false,
    var isWithSpecial: Boolean = false,
    var length: Int = 0
)
