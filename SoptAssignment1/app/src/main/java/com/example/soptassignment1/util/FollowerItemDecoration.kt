package com.example.soptassignment1.util

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView

class FollowerItemDecoration(private val divHeight : Int, @ColorInt private val divColor: Int) : RecyclerView.ItemDecoration(){
    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent : RecyclerView, state : RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = divHeight
        outRect.bottom = divHeight
    }

    @Override
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingStart + divHeight
        val right = parent.width - parent.paddingEnd - divHeight

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)

            val top = child.bottom.toFloat() + divHeight
            val bottom = child.top.toFloat() + divHeight

            c.drawRect(left.toFloat(), top, right.toFloat(), bottom, Paint().apply { color = divColor })
        }
    }
}