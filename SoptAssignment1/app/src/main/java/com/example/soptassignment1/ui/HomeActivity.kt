package com.example.soptassignment1.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.soptassignment1.R
import com.example.soptassignment1.data.User
import com.example.soptassignment1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        //binding.activity = this@HomeActivity
        binding.user = User(R.drawable.jeonghoon, "박정훈", 26, "ENFJ", "맥북프로짱짱맨")

        // 깃허브로 이동
        binding.btnGithub.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/shb03323"))
            startActivity(intent)
        }
    }

//    fun githubBtnClick(view : View) {
//        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/shb03323"))
//        startActivity(intent)
//    }
}