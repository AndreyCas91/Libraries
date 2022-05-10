package com.gb.libraries.ui.repositorie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import com.gb.libraries.App
import com.gb.libraries.databinding.FragmentReposBinding
import com.gb.libraries.model.GithubOneUserModel
import com.gb.libraries.ui.base.BackButtonListener
import com.gb.libraries.ui.one_user.OneUserFragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ReposFragment : MvpAppCompatFragment(), ReposView, BackButtonListener {

    private var _binding: FragmentReposBinding? = null
    private val binding: FragmentReposBinding
        get() {
            return _binding!!
        }

    private val presenter: ReposPresenter by moxyPresenter {
        ReposPresenter(
            App.instance.router
        )
    }

    private val initRepo by lazy {
        requireArguments().getParcelable<GithubOneUserModel>(REPO_KEY)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReposBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewName.text = initRepo.name
        binding.textLanguage.text = initRepo.language
    }

    companion object {

        const val REPO_KEY = "repo key"

        fun newInstance(githubOneUserModel: GithubOneUserModel): OneUserFragment {

            return OneUserFragment().apply {
                arguments = bundleOf(REPO_KEY to githubOneUserModel)
            }
        }
    }

    override fun backPressed() = presenter.backPressed()
}