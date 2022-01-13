package com.sonu.jetpacknavigationexample

import androidx.navigation.fragment.findNavController
import com.sonu.jetpacknavigationexample.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    override fun getViewBinding(): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater)

    override fun setUpViews() {
        binding.buttonConfirm.setOnClickListener {
            val action =
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(binding.editTextUsername.text.toString())
            findNavController().navigate(action)
        }
    }

}