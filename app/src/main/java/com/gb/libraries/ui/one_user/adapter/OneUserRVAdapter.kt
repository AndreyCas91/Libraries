package com.gb.libraries.ui.one_user.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gb.libraries.databinding.ItemReposBinding
import com.gb.libraries.databinding.ItemUserBinding
import com.gb.libraries.model.GithubOneUserModel
import com.gb.libraries.model.GithubUserModel
import com.gb.libraries.ui.base.ImageLoader

class OneUserRVAdapter(
    private val itemClickListener: (GithubOneUserModel) -> Unit
): ListAdapter<GithubOneUserModel, OneUserRVAdapter.ReposViewHolder>(GithubReposItemCallback)  {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReposViewHolder {
        return ReposViewHolder(ItemReposBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: OneUserRVAdapter.ReposViewHolder, position: Int) {
        holder.showUser(currentList[position])
    }

    inner class ReposViewHolder(private val vb: ItemReposBinding) : RecyclerView.ViewHolder(vb.root) {

        fun showUser(githubOneUserModel: GithubOneUserModel) {

            vb.root.setOnClickListener { itemClickListener(githubOneUserModel) }
            vb.tvRepos.text = githubOneUserModel.name
        }
    }
}

object GithubReposItemCallback : DiffUtil.ItemCallback<GithubOneUserModel>() {
    override fun areItemsTheSame(
        oldItem: GithubOneUserModel,
        newItem: GithubOneUserModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: GithubOneUserModel,
        newItem: GithubOneUserModel
    ): Boolean {
        return oldItem == newItem
    }

}