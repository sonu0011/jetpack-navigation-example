package com.sonu.jetpacknavigationexample

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sonu.jetpacknavigationexample.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {
    private val args: WelcomeFragmentArgs by navArgs()

    override fun getViewBinding(): FragmentWelcomeBinding =
        FragmentWelcomeBinding.inflate(layoutInflater)

    override fun setUpViews() {
        binding.textViewUsername.text = args.username
        binding.buttonOk.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }

}