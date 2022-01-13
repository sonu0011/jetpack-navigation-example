package com.sonu.jetpacknavigationexample

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sonu.jetpacknavigationexample.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val args: LoginFragmentArgs by navArgs()

    override fun getViewBinding(): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater)

    override fun setUpViews() {
        val userNameDeepLink = args.username
        //if username is null since edit text supports null value it will just remain empty

        binding.editTextUsername.setText(userNameDeepLink)
        binding.buttonConfirm.setOnClickListener {
            val action =
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(binding.editTextUsername.text.toString())
            findNavController().navigate(action)
        }
    }

}