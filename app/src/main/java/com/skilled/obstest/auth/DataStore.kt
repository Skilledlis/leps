package com.skilled.obstest.auth

import android.content.SharedPreferences
import com.skilled.obstest.data.User

/**
 * @created 10.12.2022
 * @author SkilledLis
 */
interface DataStore {
    fun getUser(): User?

    class Base(private val sharedPreferences: SharedPreferences) : DataStore {
        override fun getUser(): User? {

            sharedPreferences.apply {
                val login = getString(LOGIN, null)
                val password = getString(PASSWORD, null)
                if (login != null && password != null)
                    return User(login, password)
                return null
            }
        }
    }

    companion object {
        private const val LOGIN = "Login"
        private const val PASSWORD = "Password"
    }
}
