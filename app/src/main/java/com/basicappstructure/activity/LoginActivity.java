package com.basicappstructure.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.basicappstructure.R;
import com.basicappstructure.baseclass.BaseActivity;
import com.basicappstructure.connection.APIClass;
import com.basicappstructure.connection.InterActorCallback;
import com.basicappstructure.model.Login;
import com.basicappstructure.utils.ImageSelectActivity;
import com.google.gson.JsonObject;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    private void callLoginApi() {
        JsonObject jsonObject = new JsonObject();

        APIClass.getInstance().callLoginApi(jsonObject, new InterActorCallback<Login>() {
            @Override
            public void onStart() {
                showProgressBar(true);
            }

            @Override
            public void onResponse(Login response) {

                showProgressBar(false);

            }

            @Override
            public void onError(String message) {

                showProgressBar(false);
            }
        });
    }


    public void imagePickerDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.select_image_dialog);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        TextView tvSelectFromCamera = (TextView) dialog.findViewById(R.id.tvSelectFromCamera);
        TextView tvSelectFromgallery = (TextView) dialog.findViewById(R.id.tvSelectFromGallery);
        TextView dialogButton = (TextView) dialog.findViewById(R.id.tvCancelDialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tvSelectFromCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                takePhotoFromCamera();
            }
        });
        tvSelectFromgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                choosePhotoFromGallary();
            }
        });
        dialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent intent = new Intent(this, ImageSelectActivity.class);
        intent.putExtra(ImageSelectActivity.FLAG_COMPRESS, true);//default is true
        intent.putExtra(ImageSelectActivity.FLAG_CAMERA, false);//default is true
        intent.putExtra(ImageSelectActivity.FLAG_GALLERY, true);//default is true
        startActivityForResult(intent, 1213);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(this, ImageSelectActivity.class);
        intent.putExtra(ImageSelectActivity.FLAG_COMPRESS, true);//default is true
        intent.putExtra(ImageSelectActivity.FLAG_CAMERA, true);//default is true
        intent.putExtra(ImageSelectActivity.FLAG_GALLERY, false);//default is true
        startActivityForResult(intent, 1213);
    }

}
