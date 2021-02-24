package com.braincs.nativedlopen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

/**
 * Created by Shuai
 * 2/24/21.
 */
public class NDlopenActivity extends AppCompatActivity {

    static {
        System.loadLibrary("sdk");
        System.loadLibrary("sdkapi");
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndlopen);

        File appPath = new File(getPackageCodePath());
        String libPath = appPath.getParent() + "/lib/arm64/libmegvii3_sdk.so";


        TextView textView = findViewById(R.id.tv);
        textView.setText(getVersion());
    }

    public native String getVersion();
}
