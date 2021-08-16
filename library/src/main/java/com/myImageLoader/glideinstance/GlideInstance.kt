package com.myImageLoader.glideinstance

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.myImageLoader.module.GlideApp
import com.myImageLoader.module.GlideRequest

object GlideInstance {

    private fun loadUrlImage(
            @NonNull mCtx: Context,
            @NonNull imageRes: String,
            @NonNull placeholderRes:Int
    ): GlideRequest<Drawable?> {
        return GlideApp
                .with(mCtx)
                .load(imageRes)
                .placeholder(placeholderRes)
                .transition(DrawableTransitionOptions.withCrossFade(500))
    }

    private fun loadLocalImage(
            @NonNull mCtx: Context,
            @NonNull imageRes: Int,
            @NonNull placeholderRes:Int
    ): GlideRequest<Drawable?> {
        return GlideApp
                .with(mCtx)
                .load(imageRes)
                .placeholder(placeholderRes)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
    }

}