package com.example.soptassignment1.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.view.forEach
import androidx.recyclerview.widget.RecyclerView
import com.example.soptassignment1.R

class FollowerItemDecoration(private val padding : Int, private val divHeight : Float, @ColorInt private val divColor: Int) : RecyclerView.ItemDecoration(){
    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent : RecyclerView, state : RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        with(outRect) {
            top = padding
            bottom = padding
            right = padding
            left = padding
        }
    }

    @Override
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val paint = Paint()
        paint.color = divColor
        val left = parent.paddingStart
        val right = parent.width - parent.paddingEnd
        parent.forEach { view ->
            val top = (view.bottom + padding).toFloat()
            val bottom = top + divHeight
            c.drawRect(left.toFloat(), top, right.toFloat(), bottom, paint)
        }
    }
}