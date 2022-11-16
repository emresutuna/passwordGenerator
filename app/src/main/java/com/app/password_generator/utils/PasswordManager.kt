package com.app.password_generator.utils

import java.security.SecureRandom
import java.util.logging.Logger


class PasswordManager {

    val letters : String = "abcdefghijklmnopqrstuvwxyz"
    val uppercaseLetters : String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val numbers : String = "0123456789"
    val special : String = "@#=+!£$%&?"
    val maxPasswordLength : Float = 20F
    val maxPasswordFactor : Float = 10F

    companion object {
        val logger = Logger.getLogger(PasswordManager::class.java.name)
    }
    fun generatePassword(isWithLetters: Boolean,
                         isWithUppercase: Boolean,
                         isWithNumbers: Boolean,
                         isWithSpecial: Boolean,
                         length: Int) : String {

        var result = ""
        var i = 0

        if(isWithLetters){ result += this.letters }
        if(isWithUppercase){ result += this.uppercaseLetters }
        if(isWithNumbers){ result += this.numbers }
        if(isWithSpecial){ result += this.special }

        val rnd = SecureRandom.getInstance("SHA1PRNG")
        val sb = StringBuilder(length)

        while (i < length) {
            val randomInt : Int = rnd.nextInt(result.length)
            sb.append(result[randomInt])
            i++
        }

        return sb.toString()
    }


    fun evaluatePassword(passwordToTest: String) : Float {
        var factor = 0
        var length = passwordToTest.length

        if( passwordToTest.matches( Regex(".*["+this.letters+"].*") ) ) { factor += 2 }
        if( passwordToTest.matches( Regex(".*["+this.uppercaseLetters+"].*") ) ){ factor += 2 }
        if( passwordToTest.matches( Regex(".*["+this.numbers+"].*") ) ){ factor += 1 }
        if( passwordToTest.matches( Regex(".*["+this.special+"].*") ) ){ factor += 5 }

        return (factor*length)/(maxPasswordFactor*maxPasswordLength)
    }

}