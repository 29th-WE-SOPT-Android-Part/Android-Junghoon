package com.example.soptassignment1.util

import android.app.Application
import androidx.annotation.Px
import kotlin.math.roundToInt

class PixelRatio(private val app: Application) {
    private val displayMetrics
    get() = app.resources.displayMetrics

    @Px
    fun px(dp: Int) = (dp * displayMetrics.density).roundToInt()
}