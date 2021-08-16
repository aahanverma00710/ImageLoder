package com.myImageLoader.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ProgressBar
import com.google.android.material.imageview.ShapeableImageView
import com.myImageLoader.R
import com.myImageLoader.interfaces.OnImageLoadingListener
import com.myImageLoader.utils.hide
import com.myImageLoader.utils.show

class ImageViewLoader @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
        FrameLayout(context, attrs) {
    private val defaultRadius = 10f

    /**
     * @siView : ShapeableImageView
     * New material Image view easy to use and can be used for rounding corners
     * No need to add any more new image library
     * #link :https://developer.android.com/reference/com/google/android/material/imageview/ShapeableImageView
     **/
    private var siView: ShapeableImageView? = null

    /**
     * @mProgressBar : ProgressBar
     * Displaying loader while loading image it will disappear when is loaded
     **/
    private var mProgressBar: ProgressBar? = null

    /**
     * @showProgress : Boolean to show progress while loading image into Glide
     * Default =  true
     **/
    private var showProgress = true

    /**
     * @roundCorners : Boolean to check if we want to round corners of shapeable imageview
     * Default is true with @roundRadius 10f as default radius
     **/
    private var roundCorners = true
    private var roundRadius = defaultRadius

    /**
     * @urlToLoad :String variable to store image url to load image in glide
     **/
    private var urlToLoad: CharSequence? = null

    /**
     * @placeHolderRes Its a image or which we will show till the image is loading
     **/
    private var placeHolderRes = R.drawable.ic_pick_image_place_holder
    private var localImageRes: Int? = null

    /**
     * @loadingType : Mode in which image view is gonna load image
     * We can laod image as local means
     **/
    private val LOCAL_IMAGE_LOADING = 0 // Drawable Images
    private val URL_IMAGE_LOADING = 1 // Load from Url or File object
    private var loadingType = URL_IMAGE_LOADING
    private var loadingCallBack : OnImageLoadingListener?=null
    init {
        inflate(context, R.layout.image_view_loader, this)
        siView = this.findViewById(R.id.lPImages)
        mProgressBar = this.findViewById(R.id.progressImage)

        val typedArray: TypedArray =
                context.obtainStyledAttributes(attrs, R.styleable.MyImageProgress)
        showProgress = typedArray.getBoolean(
                R.styleable.MyImageProgress_showProgressView,
                true
        )
        roundCorners = typedArray.getBoolean(
                R.styleable.MyImageProgress_roundCorners,
                false
        )
        roundRadius = typedArray.getDimension(
                R.styleable.MyImageProgress_floatRoundRadius,
                resources.getDimension(R.dimen._5sdp)
        )
        val urlToLoadUrl: Int = typedArray.getResourceId(
                R.styleable.MyImageProgress_urlToLoad,
                R.string._to_load
        )
        urlToLoad = resources.getString(urlToLoadUrl)
        placeHolderRes = typedArray.getResourceId(R.styleable.MyImageProgress_placeholder_item, R.drawable.ic_pick_image_place_holder)
        localImageRes = typedArray.getResourceId(R.styleable.MyImageProgress_loadingMode, -1)

        loadingType = typedArray.getInt(R.styleable.MyImageProgress_loadingMode, URL_IMAGE_LOADING)
        if (showProgress) {
            mProgressBar?.show()
        } else {
            mProgressBar?.hide()
        }
        if (roundCorners) {
            setCorners(roundRadius)
        }
        if (!urlToLoad?.equals("")!!) {
            loadImage(context)
        }
    }

    private fun loadImage(context: Context) {
        if (loadingType == URL_IMAGE_LOADING && urlToLoad!! == "") {
            throw TypeCastException("Loading mismatch error\n Please select mode as 1 and pass loading url")
        }
        if (loadingType == LOCAL_IMAGE_LOADING && localImageRes != null && localImageRes != -1) {
            throw TypeCastException("Loading mismatch error\n Please select mode as 0 and pass loading Local image resource")
        }

        if (loadingType == URL_IMAGE_LOADING) {

        } else {

        }
    }

    fun setRoundRadius(radius: Float) {
        this.roundRadius = radius
    }

    private fun getImageView(): ShapeableImageView? {
        return siView
    }

    private fun setCorners(floatRoundRadius: Float) {
        getImageView()!!.shapeAppearanceModel = getImageView()!!.shapeAppearanceModel
                .toBuilder()
                .setAllCornerSizes(floatRoundRadius)
                .build()
    }
}