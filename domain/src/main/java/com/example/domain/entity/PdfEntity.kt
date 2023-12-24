package com.example.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PdfEntity(
    val appendix: String? = null,
    val chapter3: String? = null,
    val chapter6: String? = null,
    val chapter7: String? = null,
    val extraChapter1: String? = null,
    val extraChapter2: String? = null,
    val extraChapter3: String? = null,
    val extraChapter4: String? = null
) : Parcelable