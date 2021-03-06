package com.example.soptassignment1.ui.home.follower.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soptassignment1.R
import com.example.soptassignment1.databinding.ActivityDetailBinding
import com.example.soptassignment1.databinding.ActivityHomeBinding
import kotlin.properties.Delegates

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        var name = intent.getStringExtra("name")!!
        var introduction = intent.getStringExtra("introduction")!!
        var image = intent.getIntExtra("image", -1)
        initData(name, introduction, image)

        setContentView(binding.root)
    }

    private fun initData(name: String, introduction: String, image: Int) {
        binding.tvMyName.text = name
        binding.tvIntroduction.text = introduction
        binding.imageView.setImageResource(image)
    }
}