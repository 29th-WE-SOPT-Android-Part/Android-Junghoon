package com.example.soptassignment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soptassignment1.databinding.FragmentFollowerBinding


class FollowerFragment : Fragment() {
    private lateinit var followerAdapter: FollowerAdapter
    private var _binding : FragmentFollowerBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter()

        binding.rvFollower.adapter = followerAdapter

        followerAdapter.userList.addAll(
            listOf(
                UserData("최유림", "안드로이드 YB"),
                UserData("이창환", "안드로이드 YB"),
                UserData("이호재", "안드로이드 YB"),
                UserData("문다빈", "안드로이드 대장"),
                UserData("이강민", "안드로이드 OB"),
                UserData("오예원", "서버 OB"),
                UserData("김송현", "운영팀장")
            )
        )

        followerAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}