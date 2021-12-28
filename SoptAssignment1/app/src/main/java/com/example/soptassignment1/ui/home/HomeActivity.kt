package com.example.soptassignment1.ui.home

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soptassignment1.ui.home.follower.FollowerFragment
import com.example.soptassignment1.R
import com.example.soptassignment1.ui.home.repository.RepositoryFragment
import com.example.soptassignment1.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        initTransactionEvent()

        setContentView(binding.root)
        buttonGithub()
    }

    private fun initTransactionEvent() {
        val fragmentFollower = FollowerFragment()
        val fragmentRepository = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragment_container_view_tag, fragmentFollower).commit()

        buttonFollower(fragmentFollower)
        buttonRepository(fragmentRepository)
    }

    // 깃허브로 이동
    private fun buttonGithub() {
        binding.btnGithub.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/shb03323"))
            startActivity(intent)
        }
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