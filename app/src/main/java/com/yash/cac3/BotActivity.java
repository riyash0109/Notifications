package com.yash.cac3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.zip.Inflater;

public class BotActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);
        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemReselectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer , new HomeFragment1());

    }
    private NavigationBarView.OnItemReselectedListener navlistener = new NavigationBarView.OnItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new HomeFragment1();
                    break;
                case R.id.nav_home1:
                    selectedFragment = new HomeFragment2();
                    break;
                case R.id.nav_home2:
                    selectedFragment = new HomeFragment3();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, selectedFragment).commit();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.item1:
                Intent i = new Intent(Intent.ACTION_DIAL , Uri.parse("tel:8825221586"));
                startActivity(i);
                break;
        }
        return true;
    }
}