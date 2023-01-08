package com.ydhnwb.learnjetpacknav.feature.register

import androidx.fragment.app.Fragment
import com.ydhnwb.learnjetpacknav.app.FragmentKey
import com.zhuinden.simplestack.ScopeKey
import kotlinx.parcelize.Parcelize

@Parcelize
data object EnterProfileDataKey : FragmentKey(), ScopeKey.Child {
    override fun getParentScopes(): List<String> = listOf(RegistrationViewModel::class.java.name)

    override fun instantiateFragment(): Fragment = EnterProfileDataFragment()
}