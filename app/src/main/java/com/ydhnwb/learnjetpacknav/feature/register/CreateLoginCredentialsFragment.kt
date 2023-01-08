package com.ydhnwb.learnjetpacknav.feature.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rxjava2.subscribeAsState
import com.ydhnwb.learnjetpacknav.core.ComposeFragment
import com.ydhnwb.learnjetpacknav.utils.set
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestackextensions.servicesktx.lookup

class CreateLoginCredentialsFragment : ComposeFragment(){
    @Composable
    override fun FragmentComposable(backstack: Backstack) {
        val registrationViewModel = remember { backstack.lookup<RegistrationViewModel>() }

        val username = registrationViewModel.username.subscribeAsState(initial = "")
        val password = registrationViewModel.password.subscribeAsState(initial = "")

        val isEnabled = registrationViewModel.isRegisterAndLoginEnabled.subscribeAsState(initial = false)

        CreateLoginCredentialsScreenLayout(
            username = username,
            usernameUpdater = registrationViewModel.username::set,
            password = password,
            passwordUpdater = registrationViewModel.password::set,
            isButtonEnabled = isEnabled,
            onButtonClicked = registrationViewModel::onRegisterAndLoginClicked
        )
    }
}