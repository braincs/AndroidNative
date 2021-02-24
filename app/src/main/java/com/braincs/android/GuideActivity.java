package com.braincs.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.braincs.nativedlopen.NDlopenActivity;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void demoDlopenActivity(View view) {
        Intent intent = new Intent(GuideActivity.this, NDlopenActivity.class);
        startActivity(intent);
    }
}
