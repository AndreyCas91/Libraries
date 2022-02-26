package com.gb.libraries.ui.base

interface ImageLoader<T> {

    fun loadInto(url: String, container: T)
}
