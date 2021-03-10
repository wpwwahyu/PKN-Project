package com.example.ngalam112v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainSplash extends AppCompatActivity {
    private TextView txt;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_splash);
        txt = (TextView)findViewById(R.id.txt);
        img = (ImageView)findViewById(R.id.img);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.transition);
        txt.startAnimation(myanim);
        img.startAnimation(myanim);

        final Intent in = new Intent(this, MainSignin.class);
        Thread timer = new Thread(){
            public void run () {
                try {
                    sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(in);
                    finish();
                }
            }
        };
        timer.start();
    }
}
