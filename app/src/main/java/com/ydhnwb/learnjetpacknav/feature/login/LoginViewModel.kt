package com.ydhnwb.learnjetpacknav.feature.login

import com.jakewharton.rxrelay2.BehaviorRelay
import com.ydhnwb.learnjetpacknav.app.theme.AuthenticationManager
import com.ydhnwb.learnjetpacknav.feature.profile.ProfileKey
import com.ydhnwb.learnjetpacknav.feature.register.EnterProfileDataKey
import com.ydhnwb.learnjetpacknav.utils.get
import com.ydhnwb.learnjetpacknav.utils.set
import com.zhuinden.statebundle.StateBundle
import com.zhuinden.rxvalidatebykt.validateBy
import com.zhuinden.simplestack.*
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class LoginViewModel (
    private val authenticationManager: AuthenticationManager,
    private val backstack: Backstack,
) : Bundleable,ScopedServices.Registered {

    private val compositeDisposable = CompositeDisposable()
    private val isLoginEnabledRelay = BehaviorRelay.createDefault(false)

    val username = BehaviorRelay.createDefault("")
    val password = BehaviorRelay.createDefault("")
    val isLoginEnabled : Observable<Boolean> = isLoginEnabledRelay

    override fun toBundle(): StateBundle {
        return StateBundle().apply {
            putString("username", username.get())
            putString("password", password.get())
        }
    }

    override fun fromBundle(bundle: StateBundle?) {
        bundle?.run {
            username.set(getString("username", ""))
            password.set(getString("password", ""))
        }
    }

    override fun onServiceRegistered() {
        validateBy(
            username.map { it.isNotBlank() },
            password.map { it.isNotBlank() }
        ).subscribeBy { isEnabled ->
            isLoginEnabledRelay.set(isEnabled)
        }.addTo(compositeDisposable)
    }

    override fun onServiceUnregistered() {
        compositeDisposable.clear()
    }

    fun onLoginClicked() {
        if (!isLoginEnabledRelay.get()) {
            return
        }

        val username = username.get()
        authenticationManager.saveRegistration(username)
        backstack.setHistory(History.of(ProfileKey(username)), StateChange.REPLACE)
    }

    fun onRegisterClicked() {
        backstack.goTo(EnterProfileDataKey)
    }

}