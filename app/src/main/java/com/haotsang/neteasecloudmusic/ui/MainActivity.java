package com.haotsang.neteasecloudmusic.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.haotsang.neteasecloudmusic.R;
import com.haotsang.neteasecloudmusic.ui.radio.RecommendRadioFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new RecommendRadioFragment())
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }
}