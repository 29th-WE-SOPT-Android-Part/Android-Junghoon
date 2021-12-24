package com.example.soptassignment1.ui.starting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.soptassignment1.R
import com.example.soptassignment1.databinding.FragmentStart1Binding
import com.example.soptassignment1.databinding.FragmentStart2Binding

class StartFragment2 : Fragment() {
    private var _binding: FragmentStart2Binding? = null
    private val binding get() = _binding ?: error("Binding이 초기화되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStart2Binding.inflate(layoutInflater, container, false)
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment2_to_startFragment3)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}