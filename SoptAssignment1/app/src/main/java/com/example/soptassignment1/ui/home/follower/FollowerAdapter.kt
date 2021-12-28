package com.example.soptassignment1.ui.home.follower

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.soptassignment1.R
import com.example.soptassignment1.data.UserData
import com.example.soptassignment1.databinding.FollowerListBinding
import com.example.soptassignment1.ui.home.follower.detail.DetailActivity

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

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
            intent.putExtra("name", userList[position].name)
            intent.putExtra("introduction", userList[position].introduction)
            intent.putExtra("image", R.drawable.user)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = userList.size

    class FollowerViewHolder(private val binding: FollowerListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: UserData) {
            binding.tvProfileName.text = data.name
            binding.tvProfileIntroduce.text = data.introduction
        }
    }
}