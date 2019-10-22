package com.basicappstructure.activity;


import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.basicappstructure.R;

public class CameraActivity extends AppCompatActivity {

    private CameraManager cameraManager;
    private int cameraFacing;

    private String CAMERA_REQUEST_CODE = "111";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        initialization();
    }

    private void initialization() {





    }


}
