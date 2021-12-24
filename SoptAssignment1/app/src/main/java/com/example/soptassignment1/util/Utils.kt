package com.example.soptassignment1.util

import android.content.Context
import android.widget.Toast

object Utils {
    fun Context.shortToast(message : String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun Context.longToast(message : String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}