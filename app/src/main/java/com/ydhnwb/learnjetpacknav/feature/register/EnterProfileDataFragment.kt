package com.ydhnwb.learnjetpacknav.feature.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rxjava2.subscribeAsState
import com.ydhnwb.learnjetpacknav.core.ComposeFragment
import com.ydhnwb.learnjetpacknav.utils.set
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestackextensions.servicesktx.lookup

class EnterProfileDataFragment : ComposeFragment() {
    @Composable
    override fun FragmentComposable(backstack: Backstack) {
        val registrationViewModel = remember { backstack.lookup<RegistrationViewModel>() }

        val fullName = registrationViewModel.fullName.subscribeAsState(initial = "")
        val bio = registrationViewModel.bio.subscribeAsState(initial = "")

        val isEnabled = registrationViewModel.isEnterProfileNextEnabled.subscribeAsState(initial = false)

        EnterProfileDataScreenLayout(
            fullName = fullName,
            bio = bio,
            fullNameUpdater = registrationViewModel.fullName::set,
            bioUpdater = registrationViewModel.bio::set,
            onButtonClicked = registrationViewModel::onEnterProfileNextClicked,
            isButtonEnabled = isEnabled,
        )
    }
}