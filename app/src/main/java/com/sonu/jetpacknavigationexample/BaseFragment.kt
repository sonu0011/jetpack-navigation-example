package com.sonu.jetpacknavigationexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VBinding : ViewBinding> : Fragment() {
    private val TAG = "BaseFragment"

    private var _binding: VBinding? = null
    val abc = "text"

    protected val binding get() = _binding!!

    protected abstract fun getViewBinding(): VBinding

    open fun setUpViews() {}

    open fun observeData() {}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        observeData()
    }

    private fun init() {
        _binding = getViewBinding()
    }

}