package com.gb.libraries.ui.one_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.gb.libraries.App
import com.gb.libraries.ui.base.BackButtonListener
import com.gb.libraries.databinding.FragmentUserBinding
import com.gb.libraries.domain.one_user.GithubOneUserRepo
import com.gb.libraries.model.GithubOneUserModel
import com.gb.libraries.model.GithubUserModel
import com.gb.libraries.network.ApiHolder
import com.gb.libraries.ui.base.GlideImageLoader
import com.gb.libraries.ui.base.ImageLoader
import com.gb.libraries.ui.one_user.adapter.OneUserRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class OneUserFragment : MvpAppCompatFragment(), OneUserView, BackButtonListener {

    private val imageLoader: ImageLoader<ImageView> = GlideImageLoader()

    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding
        get() {
            return _binding!!
        }

    private val presenter: OneUserPresenter by moxyPresenter {
        OneUserPresenter(
            App.instance.router,
            GithubOneUserRepo(ApiHolder.githubApiService),
            initUser
        )
    }

    private val adapter by lazy {
        OneUserRVAdapter(presenter::onReposClicked)
    }

    /*
    при переходе с этого фрагмента на новый, почему-то вызывается initUser еще раз, и приложение падает
     */
    private val initUser by lazy {
        requireArguments().getParcelable<GithubUserModel>(USER_KEY)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initItems()
    }

    private fun initItems() {
        binding.textView.text = initUser.login
        imageLoader.loadInto(initUser.avatarUrl!!, binding.avatarImageView)

        binding.rvRepos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRepos.adapter = adapter
    }

    companion object {

        const val USER_KEY = "name key"

        fun newInstance(githubUserModel: GithubUserModel): OneUserFragment {

            return OneUserFragment().apply {
                arguments = bundleOf(USER_KEY to githubUserModel)
            }
        }
    }

    override fun backPressed() = presenter.backPressed()

    override fun updateList(items: List<GithubOneUserModel>) {
        adapter.submitList(items)
    }

    override fun showError(message: String?) {
        Toast.makeText(requireContext(), message.orEmpty(), Toast.LENGTH_SHORT)
            .show()
    }

}
