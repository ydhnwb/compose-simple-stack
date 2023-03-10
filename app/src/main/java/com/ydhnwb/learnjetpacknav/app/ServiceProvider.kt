package com.ydhnwb.learnjetpacknav.app

import com.ydhnwb.learnjetpacknav.feature.register.RegistrationViewModel
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider
import com.zhuinden.simplestackextensions.servicesktx.add
import com.zhuinden.simplestackextensions.servicesktx.lookup

class ServiceProvider : DefaultServiceProvider() {
    override fun bindServices(serviceBinder: ServiceBinder) {
        super.bindServices(serviceBinder)
        val scope = serviceBinder.scopeTag
        with(serviceBinder){
            when (scope) {
                //TODO: add viewmodel dependencies
                RegistrationViewModel::class.java.name -> {
                    add(RegistrationViewModel(lookup(), backstack))
                }
                else -> {}
            }

        }
    }
}