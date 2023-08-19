package com.android.base_mvvm.utils.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

fun ImageView.loadImage(source: String?) {
    val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
    Glide.with(context)
        .load(source ?: "")
        .transition(DrawableTransitionOptions.withCrossFade(factory))
        .into(this)
}