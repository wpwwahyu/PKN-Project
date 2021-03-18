package com.example.ngalam112v2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ngalam112v2.R;

public class MainNav extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav);
        android.R.attr bottomNavigationView;
        bottomNavigationView.background = null;
        bottomNavigationView.menu.getItem(2).isEnabled = false;
    }
}