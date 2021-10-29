package com.example.soptassignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soptassignment1.databinding.FragmentComingSoonBinding
import com.example.soptassignment1.databinding.FragmentHomeBinding
import com.example.soptassignment1.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")
    private lateinit var TabViewPaperAdapter: TabViewPaperAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        initAdapter()
        initTabLayout()

        return binding.root
    }

    private fun initAdapter() {
        val fragmentList = listOf(ComingSoonFragment(), ComingSoonFragment())

        TabViewPaperAdapter = TabViewPaperAdapter(this)
        TabViewPaperAdapter.fragments.addAll(fragmentList)

        binding.vpFollowingFollower.adapter = TabViewPaperAdapter
    }

    private fun initTabLayout() {
        val tabLabel = listOf("팔로잉", "팔로워")

        TabLayoutMediator(binding.tlFollowingFollower, binding.vpFollowingFollower) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}