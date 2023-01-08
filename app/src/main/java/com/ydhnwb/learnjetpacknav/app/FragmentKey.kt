package com.ydhnwb.learnjetpacknav.app

import android.os.Parcelable
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider

abstract class FragmentKey : DefaultFragmentKey(), Parcelable, DefaultServiceProvider.HasServices {
    override fun getScopeTag(): String {
        return toString()
    }

    override fun bindServices(serviceBinder: ServiceBinder) {}
}