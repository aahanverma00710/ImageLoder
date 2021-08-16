package com.myImageLoader.glideinstance

import android.widget.ProgressBar
import com.google.android.material.imageview.ShapeableImageView

class ImageLoader {
    private var siView: ShapeableImageView? = null
    private var mProgressBar: ProgressBar? = null
    private var showProgress = false
    private var isLocalImage = false


    companion object {
        fun init(): ImageLoader {
            return ImageLoader()
        }
    }

    internal fun setImageView(siView: ShapeableImageView?): ImageLoader {
        if (siView == null) {
            throw NullPointerException("Image view cant be null")
        }
        this.siView = siView
        return this
    }

    internal fun setProgress(mBar: ProgressBar?): ImageLoader {
        if (siView == null) {
            throw NullPointerException("ProgressBar cant be null")
        }
        this.mProgressBar = mBar
        return this
    }
}