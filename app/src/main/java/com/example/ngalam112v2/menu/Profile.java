package com.example.ngalam112v2.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ngalam112v2.MainActivity;
import com.example.ngalam112v2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.history:
                        startActivity(new Intent(getApplicationContext()
                                , History.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.form:
                        startActivity(new Intent(getApplicationContext()
                                , Form.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        return true;

                    case R.id.about:
                        startActivity(new Intent(getApplicationContext()
                                , About.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}