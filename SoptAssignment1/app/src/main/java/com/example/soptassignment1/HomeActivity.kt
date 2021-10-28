package com.example.soptassignment1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soptassignment1.databinding.ActivityHomeBinding
import com.example.soptassignment1.databinding.ActivitySigninBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        initTransactionEvent()

        setContentView(binding.root)
    }

    private fun initTransactionEvent() {
        val fragmentFollower = FollowerFragment()
        val fragmentRepository = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragment_container_view_tag, fragmentFollower).commit()

        buttonFollower(fragmentFollower)
        buttonRepository(fragmentRepository)
    }

    // 팔로워 fragment
    private fun buttonFollower(fragmentFollower : FollowerFragment) {
        binding.btnFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_tag, fragmentFollower)
            transaction.commit()
        }
    }

    // 레포지토리 fragment
    private fun buttonRepository(fragmentRepository : RepositoryFragment) {
        binding.btnRepository.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_tag, fragmentRepository)
            transaction.commit()
        }
    }
}