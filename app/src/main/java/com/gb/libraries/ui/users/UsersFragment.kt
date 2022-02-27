package com.gb.libraries.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.gb.libraries.*
import com.gb.libraries.databinding.FragmentUsersBinding
import com.gb.libraries.domain.users.GithubUsersRepo
import com.gb.libraries.model.GithubUserModel
import com.gb.libraries.network.ApiHolder
import com.gb.libraries.ui.base.BackButtonListener
import com.gb.libraries.ui.base.GlideImageLoader
import com.gb.libraries.ui.users.adapter.UsersRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private val presenter by moxyPresenter {
        UsersPresenter(
            App.instance.router,
            GithubUsersRepo(ApiHolder.githubApiService)
        )
    }

    private var _binding: FragmentUsersBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        UsersRVAdapter(GlideImageLoader(), presenter::onUserClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUsers.adapter = adapter
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    override fun updateList(users: List<GithubUserModel>) {
        adapter.submitList(users)
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message.orEmpty(), Toast.LENGTH_SHORT)
            .show()
    }

    companion object {

        fun newInstance(): UsersFragment {
            return UsersFragment()
        }
    }

}

