package com.basicappstructure.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.basicappstructure.R;
import com.basicappstructure.utils.ImageUtils;

public class ImagePreviewActivity extends AppCompatActivity {

    private ImageView imageView;
    private String path = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);
        initialization();


    }

    private void initialization() {

        imageView = findViewById(R.id.ivImagePreview);

        if (getIntent().hasExtra("path")) {
            path = getIntent().getStringExtra("path");
        }

        Log.e("path: ", path);

        ImageUtils.displayImage(path, imageView, this);


    }
}
