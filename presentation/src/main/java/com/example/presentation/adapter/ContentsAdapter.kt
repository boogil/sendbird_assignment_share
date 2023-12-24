package com.example.presentation.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.BookEntity
import com.example.presentation.R
import com.example.presentation.adapter.base.BaseBindingViewHolder
import com.example.presentation.databinding.VhContentBinding
import com.example.presentation.extensions.setGlideImgResource
import com.example.presentation.util.inflate

/**
 * 컨텐츠 어뎁터 (TOTAL, LIKES 에서 공용으로 사용중)
 */
class ContentsAdapter : PagingDataAdapter<BookEntity, BaseBindingViewHolder<ViewDataBinding>>(object : DiffUtil.ItemCallback<BookEntity>() {
    override fun areItemsTheSame(oldItem: BookEntity, newItem: BookEntity): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: BookEntity, newItem: BookEntity): Boolean = oldItem.hashCode() == newItem.hashCode()
}) {
    lateinit var itemClickListener: (content: BookEntity) -> Unit?

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder<ViewDataBinding> {
        return ContentViewHolder(parent.inflate(R.layout.vh_content))
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder<ViewDataBinding>, position: Int) {
        holder.onBind(position)
    }

    inner class ContentViewHolder(view: View) : BaseBindingViewHolder<VhContentBinding>(view) {
        override fun onBind(position: Int) {
            super.onBind(position)
            val data = getItem(position) ?: return

            binding.tvTitle.text = data.title
            binding.tvTime.text = data.price
            binding.tvDescription.text = data.subtitle
            data.image?.let { binding.ivContent.setGlideImgResource(it) }
            binding.clWrapper.setOnClickListener {
                itemClickListener.invoke(data)
            }
        }
    }

    companion object {
        /**
         * @param itemClickListener 아이템 클릭 리스너
         */
        fun newInstance(itemClickListener: (content: BookEntity) -> Unit?): ContentsAdapter = ContentsAdapter().apply {
            this.itemClickListener = itemClickListener
        }
    }
}