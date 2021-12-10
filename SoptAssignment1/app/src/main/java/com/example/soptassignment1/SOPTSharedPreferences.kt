package com.example.soptassignment1

import android.content.Context
import android.content.SharedPreferences

object SOPTSharedPreferences {
    private const val STORAGE_KEY = "com.example.soptassignment1"
    private const val AUTO_LOGIN = "AUTO_LOGIN"
    private const val FIRST_START = "FIRST_START"

    private fun getPreferences(context: Context) =
        context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)

    fun getAutoLogin(context: Context) = getPreferences(context).getBoolean(AUTO_LOGIN, false)

    fun setAutoLogin(context: Context, value: Boolean) = getPreferences(context).edit()
        .putBoolean(AUTO_LOGIN, value)
        .apply()

    fun removeAutoLogin(context: Context) = getPreferences(context).edit()
        .remove(AUTO_LOGIN)
        .apply()

    fun clearStorage(context: Context) = getPreferences(context).edit()
        .clear()
        .apply()
}