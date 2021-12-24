package com.example.soptassignment1.ui.home.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soptassignment1.data.RepositoryData
import com.example.soptassignment1.databinding.FragmentRepositoryBinding

class RepositoryFragment : Fragment() {
    private lateinit var repositoryAdapter: RepositoryAdapter
    private var _binding : FragmentRepositoryBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        repositoryAdapter = RepositoryAdapter()

        binding.rvRepository.adapter = repositoryAdapter

        repositoryAdapter.repositoryList.addAll(
            listOf(
                RepositoryData("알고리즘", "알고리즘 풀이용 레포지토리"),
                RepositoryData("SOPT", "SOPT 과제 제출용 레포지토리"),
                RepositoryData("웹", "웹 공부용 레포지토리"),
                RepositoryData("OOP 2021-2", "OOP 팀플용 레포지토리"),
                RepositoryData("TIL", "Today I Learn"),
                RepositoryData("Kotlin", "Kotlin 스터디 레포지토리")
            )
        )

        repositoryAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}