package com.ydhnwb.learnjetpacknav.app.theme

import android.content.SharedPreferences
import androidx.core.content.edit

class AuthenticationManager(private val sharedPreferences: SharedPreferences) {
    companion object {
        private const val KEY_USERNAME = "username"
    }
    fun isAuthenticated() : Boolean = sharedPreferences.getString(KEY_USERNAME, "")!!.isNotEmpty()
    fun saveRegistration(username: String) = sharedPreferences.edit { putString(KEY_USERNAME, username) }
    fun clearRegistration() = sharedPreferences.edit { remove(KEY_USERNAME) }
    fun getAuthenticatedUser() : String = checkNotNull(sharedPreferences.getString(KEY_USERNAME, "")?.takeIf {
        it.isNotEmpty()
    }) { "Username should not be null" }
}