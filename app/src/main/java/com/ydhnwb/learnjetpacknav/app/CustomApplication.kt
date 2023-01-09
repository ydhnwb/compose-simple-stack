package com.ydhnwb.learnjetpacknav.app

import android.app.Application
import android.preference.PreferenceManager
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import com.ydhnwb.learnjetpacknav.app.theme.AuthenticationManager
import com.zhuinden.simplestack.GlobalServices
import com.zhuinden.simplestackextensions.servicesktx.add

class CustomApplication : Application() {
    lateinit var globalService: GlobalServices
        private set

    override fun onCreate() {
        super.onCreate()
        @Suppress("DEPRECATION") //TODO: change this plz
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val authenticationManager = AuthenticationManager(sharedPreferences)
        globalService = GlobalServices.builder()
            .add(authenticationManager)
            .build()
    }
}