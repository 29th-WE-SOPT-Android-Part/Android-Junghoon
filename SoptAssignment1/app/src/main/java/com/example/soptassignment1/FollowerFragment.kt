package com.example.soptassignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soptassignment1.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {
    private var _binding : FragmentFollowerBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}