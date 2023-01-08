package com.ydhnwb.learnjetpacknav.feature.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.ydhnwb.learnjetpacknav.core.ComposeFragment
import com.ydhnwb.learnjetpacknav.feature.login.LoginViewModel
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestackextensions.servicesktx.lookup

class ProfileFragment : ComposeFragment(){
    @Composable
    override fun FragmentComposable(backstack: Backstack) {
        val key = getKey<ProfileKey>()
        val profileViewModel = remember { backstack.lookup<ProfileViewModel>() }
        ProfileScreenLayout(
            username = key.username,
            onLogoutClick = profileViewModel::logout
        )
    }
}