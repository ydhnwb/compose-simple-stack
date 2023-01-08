package com.ydhnwb.learnjetpacknav.feature.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rxjava2.subscribeAsState
import androidx.compose.ui.Modifier
import com.ydhnwb.learnjetpacknav.app.theme.LearnJetpackNavTheme
import com.ydhnwb.learnjetpacknav.core.ComposeFragment
import com.ydhnwb.learnjetpacknav.utils.set
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestackextensions.servicesktx.lookup

class LoginFragment : ComposeFragment(){
    @Composable
    override fun FragmentComposable(backstack: Backstack) {
        val loginViewModel = remember { backstack.lookup<LoginViewModel>() }
        val username = loginViewModel.username.subscribeAsState(initial = "")
        val password = loginViewModel.password.subscribeAsState(initial = "")

        val isLoginEnabled = loginViewModel.isLoginEnabled.subscribeAsState(initial = false)

        //LearnJetpackNavXXX is my app name
        LearnJetpackNavTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                LoginScreenLayout(
                    username = username,
                    password = password,
                    usernameUpdater = loginViewModel.username::set,
                    passwordUpdater = loginViewModel.password::set,
                    onLoginClicked = loginViewModel::onLoginClicked,
                    onRegisterClicked = loginViewModel::onRegisterClicked,
                    isLoginEnabled = isLoginEnabled,
                )
            }
        }

    }
}