package com.braincs.nativebytes;

import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

/**
 * Created by Shuai
 * 4/10/21.
 */
public class CameraPreviewActivity extends AppCompatActivity {

    private final static String TAG = CameraPreviewActivity.class.getSimpleName();
    private Camera cameraRGB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_preview);

        initView();
    }

    private void initView() {
        TextureView tv_camera_preview = findViewById(R.id.tv_camera_preview);
        tv_camera_preview.setSurfaceTextureListener(mSurfaceTextureListener);
    }

    private TextureView.SurfaceTextureListener mSurfaceTextureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
            openCamera(surfaceTexture);
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            distroyCamera();
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

        }
    };


    //region Camera
    private void openCamera(SurfaceTexture surface) {
        cameraRGB = Camera.open(1);
        Camera.Parameters params = cameraRGB.getParameters();
//                    List<Camera.Size> allSupportedSize = params.getSupportedPictureSizes();
        params.setPreviewFormat(ImageFormat.NV21);
        params.setPreviewSize(640, 480);

        cameraRGB.setParameters(params);
        cameraRGB.setDisplayOrientation(270); // 90
//        safeCount = 0;
        try {
            cameraRGB.setPreviewTexture(surface);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cameraRGB.setPreviewCallback(rgbCallback);
        cameraRGB.startPreview();
    }

    private Camera.PreviewCallback rgbCallback = new Camera.PreviewCallback() {
        @Override
        public void onPreviewFrame(byte[] bytes, Camera camera) {
            NativeAPI.passBytes(bytes);
        }
    };

    private void distroyCamera() {
        if (cameraRGB != null) {
            cameraRGB.stopPreview();
            cameraRGB.setPreviewCallback(null);
            cameraRGB.release();
            cameraRGB = null;
        }
    }
    //endregion
}
