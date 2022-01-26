package com.gb.libraries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat
import com.gb.libraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listener = View.OnClickListener {
            val current = when (it.id){
                R.id.btn_first_fragment -> MainPresenter.ButtonSelection.FIRST
                R.id.btn_second_fragment -> MainPresenter.ButtonSelection.SECOND
                R.id.btn_third_fragment -> MainPresenter.ButtonSelection.THIRD
                else -> {throw IllegalArgumentException("")}
            }
            presenter.counterClick(current)
        }

        binding.btnFirstFragment.setOnClickListener(listener)
        binding.btnSecondFragment.setOnClickListener(listener)
        binding.btnThirdFragment.setOnClickListener(listener)


    }

    override fun setButtonText(index: Int, text: String) {
        when (index){
            0 -> binding.btnFirstFragment.text = text
            1 -> binding.btnSecondFragment.text = text
            2 -> binding.btnThirdFragment.text = text
        }
    }
}