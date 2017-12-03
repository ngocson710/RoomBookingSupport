package com.example.n_son.roombookingsupport.View.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.n_son.roombookingsupport.R;
import com.example.n_son.roombookingsupport.View.DangNhap.DangNhapActivity;

/**
 * Created by NSON on 11/23/2017.
 */

public class Splash extends AppCompatActivity{
    ImageView imageView;
    Animation animation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);
        imageView = (ImageView) findViewById(R.id.imgSplash);
        animation = AnimationUtils.loadAnimation(Splash.this, R.anim.mytransition);
        imageView.startAnimation(animation);
        final Intent intent= new Intent(this, DangNhapActivity.class);
        Thread thread= new Thread(){
            @Override
            public void run() {
                try{
                    sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
                super.run();
            }
        };
        thread.start();
    }
}
