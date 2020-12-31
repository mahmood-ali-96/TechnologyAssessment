package com.example.technologyassessment.utils;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.technologyassessment.R;

public class MyBindingAdapter {

    @SuppressLint("CheckResult")
    @BindingAdapter("LoadArticalImage")
    public static void LoadArticalImage(View view, String url) {
        ImageView imageView = (ImageView) view;
        RequestOptions options = new RequestOptions();
        options.circleCrop()
                .error(R.drawable.ic_broken_image)
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        if (url.equals("Non"))
            Glide.with(imageView.getContext()).load(R.drawable.ic_image).apply(options).into(imageView);
        else
            Glide.with(imageView.getContext()).load(url).apply(options).into(imageView);
    }

    @SuppressLint("CheckResult")
    @BindingAdapter("LoadArticalImageDetails")
    public static void LoadArticalImageDetails(View view, String url) {
        ImageView imageView = (ImageView) view;
        RequestOptions options = new RequestOptions();
        options.error(R.drawable.ic_broken_image)
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        if (url.equals("Non"))
            Glide.with(imageView.getContext()).load(R.drawable.ic_image).apply(options).into(imageView);
        else
            Glide.with(imageView.getContext()).load(url).apply(options).into(imageView);
    }
}
