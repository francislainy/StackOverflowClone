package com.example.stackoverflowclone.model

import android.R.attr
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class APIError {
    @SerializedName("success")
    @Expose
    private val success: Boolean? = null

    @SerializedName("err")
    @Expose
    val errorMessage: String? = null
    val errorCode: Int
        get() = attr.name

}
