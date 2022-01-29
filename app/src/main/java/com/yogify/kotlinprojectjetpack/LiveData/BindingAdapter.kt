package com.yogify.kotlinprojectjetpack.LiveData

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imagefromurl")
fun ImageView.imageFromurl(url:String) {
    Glide.with(this.context).load(url).into(this)
}