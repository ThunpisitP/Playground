package com.thunpisit.playground.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mindorks.retrofit.coroutines.data.model.User
import com.thunpisit.playground.databinding.ItemUserBinding
import com.thunpisit.playground.utils.load

class UserAdapter: ListAdapter<User, UserAdapter.UserViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.setData(getItem(position))
    }

    inner class UserViewHolder(private val binding: ItemUserBinding): ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun setData(item: User) {
            binding.ivUser.load(item.avatar)
            binding.tvUser.text = "${item.id} ${item.name}"
            binding.tvEmail.text = item.email
        }
    }

    companion object {
        val diffUtils = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}
