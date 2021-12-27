package com.example.soptassignment1.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("imgRes")
    fun setImage(imageView: ImageView, res: Int) {
        imageView.setImageResource(res)
    }
}