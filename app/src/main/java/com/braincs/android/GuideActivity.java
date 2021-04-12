package com.braincs.android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.braincs.nativebytes.CameraPreviewActivity;
import com.braincs.nativedlopen.NDlopenActivity;

public class GuideActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 0);
        }
    }

    public void demoDlopenActivity(View view) {
        Intent intent = new Intent(GuideActivity.this, NDlopenActivity.class);
        startActivity(intent);
    }

    public void demoNativeBytesActivity(View view) {
        Intent intent = new Intent(GuideActivity.this, CameraPreviewActivity.class);
        startActivity(intent);
    }
}
