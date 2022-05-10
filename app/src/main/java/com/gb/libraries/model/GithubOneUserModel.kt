package com.gb.libraries.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubOneUserModel(
    @Expose
    val name: String,

    @Expose
    val language: String

) : Parcelable