package com.gb.libraries

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users(): Screen {
        return FragmentScreen { UsersFragment.newInstance() }
    }

    override fun user(name: String): Screen {
        return FragmentScreen { OneUserFragment.newInstance(name) }
    }

}