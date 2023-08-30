package com.thunpisit.playground.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadCircleImage(url: String?) {
    if (url.isNullOrEmpty()) return
    Glide.with(this).load(url)
        .thumbnail(0.25f)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}

fun ImageView.load(url: String?, options: RequestBuilder<Drawable>.() -> Unit = {}) {
    Glide.with(this)
        .load(url)
        .thumbnail(0.25f)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .apply(options)
        .into(this)
}