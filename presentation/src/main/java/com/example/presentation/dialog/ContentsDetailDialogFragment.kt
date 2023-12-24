package com.example.presentation.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.presentation.R
import com.example.presentation.databinding.FragmentContentInfoBinding
import com.example.presentation.dialog.base.BaseBindingDialogFragment
import com.example.presentation.extensions.collectLatestNotNull
import com.example.presentation.extensions.fromHtml
import com.example.presentation.extensions.repeatOnStarted
import com.example.presentation.extensions.setGlideImgResource
import com.example.presentation.viewmodel.MainViewModel


class ContentsDetailDialogFragment : BaseBindingDialogFragment<FragmentContentInfoBinding>(R.layout.fragment_content_info) {
    private val contentId: String? by lazy { arguments?.getString(KEY_CONTENT_ID) }
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun getTheme(): Int = R.style.FullScreenDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObserver()
    }

    private fun setupObserver() {
        repeatOnStarted {
            mainViewModel.fetchBookDetail(contentId ?: return@repeatOnStarted).collectLatestNotNull { content ->
                binding.tvTitle.text = content.title
                binding.tvSubtitle.text = content.subtitle
                binding.tvDescription.text = content.desc
                binding.tvWriterInfo.text =
                    getString(R.string.authors_publisher_language_pages_year_rating, content.authors, content.publisher, content.language,
                              content.pages, content.year, content.rating, content.price, content.url).fromHtml()
                content.image?.let { binding.ivContent.setGlideImgResource(it) }
            }
        }
    }

    companion object {
        private const val KEY_CONTENT_ID = "key_content_id"

        fun newInstance(contentId: String?): ContentsDetailDialogFragment = ContentsDetailDialogFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_CONTENT_ID, contentId)
            }
        }
    }
}