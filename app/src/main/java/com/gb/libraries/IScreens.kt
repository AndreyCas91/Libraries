package com.gb.libraries

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(name: String): Screen
}

