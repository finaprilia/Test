package com.example.jenong.test.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.jenong.test.R;

public class SplashScreen extends Activity {

    private static int splashTime = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, UtamaActivity.class);
                startActivity(i);

                finish();
            }
        }, splashTime);
    }
}
