package com.example.presentation.dialog.base

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

abstract class BaseBindingDialogFragment<VIEW_BINDING : ViewDataBinding>(private val layoutId: Int) :
    DialogFragment() {
    lateinit var binding: VIEW_BINDING

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    open fun setCancel(setting: Boolean) {
        isCancelable = setting
    }

    open fun setWindowFeature(feature: Int) {
        activity?.requestWindowFeature(feature)
    }

    open fun setBackground(drawable: ColorDrawable) {
        activity?.window?.setBackgroundDrawable(drawable)
    }

    override fun show(fm: FragmentManager, tag: String?) {
        if (parentFragment?.activity?.isFinishing == true) return
        if (this@BaseBindingDialogFragment.isAdded) fm.commit { remove(this@BaseBindingDialogFragment) }
        super.show(fm, tag)
    }
}