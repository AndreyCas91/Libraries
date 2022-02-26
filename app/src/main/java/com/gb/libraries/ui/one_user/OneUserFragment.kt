package com.gb.libraries.ui.one_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gb.libraries.App
import com.gb.libraries.ui.base.BackButtonListener
import com.gb.libraries.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class OneUserFragment : MvpAppCompatFragment(), BackButtonListener {

    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding
        get() {
            return _binding!!
        }

    private val presenter: OneUserPresenter by moxyPresenter { OneUserPresenter(App.instance!!.router) }



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

        val name = arguments?.getString(NAME_KEY).toString()

        binding.textView.text = name
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        const val NAME_KEY = "name key"

        fun newInstance(name: String): OneUserFragment = OneUserFragment()
            .apply {
                arguments = Bundle().apply {
                    putString(NAME_KEY, name)
                }
            }
    }

    override fun backPressed() = presenter.backPressed()

}
