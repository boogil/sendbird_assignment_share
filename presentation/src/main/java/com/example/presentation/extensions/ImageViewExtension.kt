package com.example.presentation.extensions

import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import com.bumptech.glide.Glide

fun ImageView.setGlideImgResource(@DrawableRes res: Int, @DrawableRes placeHolder: Int) {
    Glide.with(this)
        .load(res)
        .placeholder(placeHolder)
        .into(this)
}

fun ImageView.setGlideImgResource(urlStr: String) {
    Glide.with(this)
        .load(urlStr)
        .into(this)
}

fun ImageView.setGlideImgResource(urlStr: String, @DrawableRes placeHolder: Int) {
    Glide.with(this)
        .load(urlStr)
        .placeholder(placeHolder)
        .into(this)
}

fun ImageView.setTint(@ColorRes tintColorRes: Int) {
    ImageViewCompat.setImageTintList(this, ContextCompat.getColorStateList(this.context, tintColorRes))
}