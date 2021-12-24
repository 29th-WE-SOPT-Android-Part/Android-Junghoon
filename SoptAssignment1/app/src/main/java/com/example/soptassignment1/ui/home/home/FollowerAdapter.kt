package com.example.soptassignment1.ui.home.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soptassignment1.R
import com.example.soptassignment1.data.UserData
import com.example.soptassignment1.databinding.FollowerListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    val userList = mutableListOf<UserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = FollowerListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    class FollowerViewHolder(private val binding: FollowerListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: UserData) {
            Glide.with(binding.ivProfile)
                .load(R.drawable.user)
                .circleCrop()
                .into(binding.ivProfile)
            binding.tvProfileName.text = data.name
            binding.tvProfileIntroduce.text = data.introduction
        }
    }
}