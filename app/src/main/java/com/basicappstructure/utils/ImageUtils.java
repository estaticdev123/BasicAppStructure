package com.basicappstructure.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.basicappstructure.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageUtils {

    public static void displayRoundImage(String URl, ImageView imageView, Context context) {
        if (URl != null && !URl.equalsIgnoreCase("")) {

            Glide.with(context)
                    .load(URl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .apply(RequestOptions.circleCropTransform())
                    .into(imageView);
        }
    }

    public static void displayRoundImage(Bitmap URl, ImageView imageView, Context context) {
        if (URl != null) {

            Glide.with(context)
                    .load(URl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .apply(RequestOptions.circleCropTransform())
                    .into(imageView);
        }
    }

    public static void displayImage(String URl, ImageView imageView, Context context) {
        if (URl != null) {

            /*long interval = 1000;
            RequestOptions options = new RequestOptions().frame(interval);
            Glide.with(context).asBitmap()
                    .load(URl)
                    .apply(options)
                    .placeholder(R.drawable.ic_group)
                    .into(imageView);*/

            Glide.with(context)
                    .load(URl)
                    .thumbnail(0.25f)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);


        }
    }
}
