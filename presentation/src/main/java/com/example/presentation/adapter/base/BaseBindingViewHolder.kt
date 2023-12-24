package com.example.presentation.adapter.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

/**
 * - **주의사항**
 *    - Adapter 안의 inner class ViewHolder일 경우에만 사용해야함
 */
abstract class BaseBindingViewHolder<out T : ViewDataBinding>(view: View) : RecyclerView.ViewHolder(view) {
    private var _binding: T? by Delegates.observable(null) { _, _, _ ->
        onCreate()
    }
    val binding: T by lazy { _binding!! }

    init {
        _binding = DataBindingUtil.bind(view)
    }
    open fun onCreate() {}
    open fun onBind(position: Int) {
        itemView.tag = position
    }

    open fun onBind(position: Int, payloads: MutableList<Any> ?= null) {
        itemView.tag = position
    }
}
