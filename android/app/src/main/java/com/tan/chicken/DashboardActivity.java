package com.tan.chicken;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class DashboardActivity extends AppCompatActivity{

    private  ChickensFragment chickensFragment;
    private ScanFragment scanFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(chickensFragment == null){
                        chickensFragment = new ChickensFragment();
                    }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, chickensFragment).commit();
                    return true;
                case R.id.navigation_scan:
                    if(scanFragment == null){
                        scanFragment = new ScanFragment();
                    }
                    scanFragment.setChickens(chickensFragment.sendChickens());
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, scanFragment).commit();
                    return true;
                case R.id.navigation_locate:
                    return true;
                case R.id.navigation_settings:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(chickensFragment == null){
            chickensFragment = new ChickensFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, chickensFragment).commit();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (scanFragment != null){
            scanFragment.resolveIntent(intent);
        }
    }

}
