package com.sonu.jetpacknavigationexample

import com.sonu.jetpacknavigationexample.databinding.FragmentSearchBinding
import com.sonu.jetpacknavigationexample.databinding.FragmentSettingsBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override fun getViewBinding(): FragmentSearchBinding =
        FragmentSearchBinding.inflate(layoutInflater)
}