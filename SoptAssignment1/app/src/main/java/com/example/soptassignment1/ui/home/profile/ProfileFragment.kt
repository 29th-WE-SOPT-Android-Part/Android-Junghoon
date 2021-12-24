package com.example.soptassignment1.ui.home.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.soptassignment1.R
import com.example.soptassignment1.databinding.FragmentProfileBinding
import com.example.soptassignment1.ui.home.home.SettingsActivity
import com.example.soptassignment1.ui.home.home.FollowerFragment
import com.example.soptassignment1.ui.home.home.RepositoryFragment

class ProfileFragment : Fragment() {
    private lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        binding = FragmentProfileBinding.inflate(layoutInflater)
        binding.btnFollower.isSelected = true

        initImage()
        initTransactionEvent()
        initButtonSettings()

        return binding.root
    }

    private fun initImage() {
        Glide.with(this)
            .load(R.drawable.beer)
            .circleCrop()
            .into(binding.ivMyProfile)
    }

    private fun initTransactionEvent() {
        val fragmentFollower = FollowerFragment()
        val fragmentRepository = RepositoryFragment()

        childFragmentManager.beginTransaction().add(R.id.fragment_container_view_tag, fragmentFollower).commit()

        buttonFollower(fragmentFollower)
        buttonRepository(fragmentRepository)
    }

    // 팔로워 fragment
    private fun buttonFollower(fragmentFollower : FollowerFragment) {
        binding.btnFollower.setOnClickListener {
            binding.btnFollower.isSelected = true
            binding.btnRepository.isSelected = false

            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_tag, fragmentFollower)
            transaction.commit()
        }
    }

    // 레포지토리 fragment
    private fun buttonRepository(fragmentRepository : RepositoryFragment) {
        binding.btnRepository.setOnClickListener {
            binding.btnFollower.isSelected = false
            binding.btnRepository.isSelected = true

            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_tag, fragmentRepository)
            transaction.commit()
        }
    }

    private fun initButtonSettings() {
        binding.ibSettings.setOnClickListener {
            startActivity(Intent(activity, SettingsActivity::class.java))
        }
    }
}