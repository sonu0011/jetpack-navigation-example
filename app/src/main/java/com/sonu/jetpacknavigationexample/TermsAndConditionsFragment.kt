package com.sonu.jetpacknavigationexample

import com.sonu.jetpacknavigationexample.databinding.FragmentTermsBinding

class TermsAndConditionsFragment : BaseFragment<FragmentTermsBinding>() {
    override fun getViewBinding(): FragmentTermsBinding =
        FragmentTermsBinding.inflate(layoutInflater)
}