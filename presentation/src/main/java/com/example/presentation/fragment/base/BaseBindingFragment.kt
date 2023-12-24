package com.example.presentation.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.presentation.util.Inflate

abstract class BaseBindingFragment<VB : ViewDataBinding>(private val inflate: Inflate<VB>) : Fragment() {

    protected lateinit var binding: VB
        private set

    var isBindingInitialized = ::binding.isInitialized

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflate.invoke(inflater, container, false).apply {
            binding = this
            lifecycleOwner = viewLifecycleOwner
        }.root
    }
}