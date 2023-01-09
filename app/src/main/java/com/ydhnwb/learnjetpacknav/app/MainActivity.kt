package com.ydhnwb.learnjetpacknav.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ydhnwb.learnjetpacknav.R
import com.ydhnwb.learnjetpacknav.app.theme.AuthenticationManager
import com.ydhnwb.learnjetpacknav.core.FragmentStateChanger
import com.ydhnwb.learnjetpacknav.feature.login.LoginKey
import com.ydhnwb.learnjetpacknav.feature.profile.ProfileKey
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.SimpleStateChanger
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.navigator.Navigator
import com.zhuinden.simplestackextensions.navigatorktx.androidContentFrame
import com.zhuinden.simplestackextensions.servicesktx.get

class MainActivity : AppCompatActivity(), SimpleStateChanger.NavigationHandler {
    private lateinit var fragmentStateChanger: FragmentStateChanger
    private lateinit var authenticationManager: AuthenticationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val app = application as CustomApplication
        val globalServices = app.globalService

        authenticationManager = globalServices.get()
        fragmentStateChanger = FragmentStateChanger(supportFragmentManager, R.id.container)
        Navigator.configure()
            .setStateChanger(SimpleStateChanger(this))
            .setScopedServices(ServiceProvider())
            .setGlobalServices(globalServices)
            .install(
                this,
                androidContentFrame,
                History.of(
                    when{
                        //similar like NavigationContainer on ReactNative
                        authenticationManager.isAuthenticated() -> ProfileKey(authenticationManager.getAuthenticatedUser())
                        else -> LoginKey
                    }
                )
            )
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if(!Navigator.onBackPressed(this)){
            super.onBackPressed()
        }
    }

    override fun onNavigationEvent(stateChange: StateChange) {
        fragmentStateChanger.handleStateChange(stateChange)
    }

    override fun onDestroy() {
        if(isFinishing){
            authenticationManager.clearRegistration()
        }
        super.onDestroy()
    }
}