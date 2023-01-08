package com.ydhnwb.learnjetpacknav.feature.profile

import com.ydhnwb.learnjetpacknav.app.theme.AuthenticationManager
import com.ydhnwb.learnjetpacknav.feature.login.LoginKey
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.ScopedServices
import com.zhuinden.simplestack.StateChange

class ProfileViewModel (
    private val authenticationManager: AuthenticationManager,
    private val backstack: Backstack
    ) : ScopedServices.Activated {
    override fun onServiceActive() {
        if (!authenticationManager.isAuthenticated()) {
            backstack.setHistory(History.of(LoginKey), StateChange.REPLACE)
        }
    }

    override fun onServiceInactive() {}

    fun logout() {
        println("logout() from profileViewModel")
        authenticationManager.clearRegistration()
        backstack.setHistory(History.of(LoginKey), StateChange.REPLACE)
    }
}