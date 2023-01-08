package com.ydhnwb.learnjetpacknav.feature.profile

import androidx.fragment.app.Fragment
import com.ydhnwb.learnjetpacknav.app.FragmentKey
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.servicesktx.add
import com.zhuinden.simplestackextensions.servicesktx.lookup
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileKey (val username: String) : FragmentKey(){
    override fun instantiateFragment(): Fragment {
        return ProfileFragment()
    }

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder){
            add(ProfileViewModel(lookup(), backstack))
        }
    }
}