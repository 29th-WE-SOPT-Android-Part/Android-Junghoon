package com.example.soptassignment1.ui.home.follower.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soptassignment1.R
import com.example.soptassignment1.databinding.ActivityDetailBinding
import kotlin.properties.Delegates

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var name = intent.getStringExtra("name")!!
        var introduction = intent.getStringExtra("introduction")!!
        var image = intent.getIntExtra("image", -1)
    }

    private fun initData(name: String, introduction: String, image: Int) {
        
    }
}