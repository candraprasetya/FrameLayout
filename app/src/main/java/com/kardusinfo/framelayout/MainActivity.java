package com.kardusinfo.framelayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kardusinfo.framelayout.fragments.DashboardFragment;
import com.kardusinfo.framelayout.fragments.FavoriteFragment;
import com.kardusinfo.framelayout.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    DashboardFragment dashboardFragment;
    FavoriteFragment favoriteFragment;
    ProfileFragment profileFragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bnvMain);

        dashboardFragment = new DashboardFragment();
        favoriteFragment = new FavoriteFragment();
        profileFragment = new ProfileFragment();

        changeFragment(dashboardFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuDashboard:
                        changeFragment(dashboardFragment);
                        break;
                    case R.id.menuFav:
                        changeFragment(favoriteFragment);
                        break;
                    case R.id.menuProfile:
                        changeFragment(profileFragment);
                        break;
                }
                return true;
            }
        });

    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameMain, fragment).commit();
    }
}
