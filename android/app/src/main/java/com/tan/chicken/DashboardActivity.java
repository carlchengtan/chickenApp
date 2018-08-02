package com.tan.chicken;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.tan.chicken.domain.Chicken;
import com.tan.chicken.dummy.DummyContent;

import java.util.List;

public class DashboardActivity extends AppCompatActivity{

    private  ChickensFragment chickensFragment;
    private  ScanFragment scanFragment;
//    private  ChickenDetailFragment chickenDetailFragment;
//    private  ChickenDetailFragment chickenDetailFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if(chickensFragment == null){
                        chickensFragment = new ChickensFragment();
                    }else{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, chickensFragment).commit();
                    }
                case R.id.navigation_scan:
                    if(scanFragment == null){
                        scanFragment = new ScanFragment();
                    }else{
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, scanFragment).commit();
                    }
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

        chickensFragment = new ChickensFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, chickensFragment).commit();
    }

//    public void onChickenClick(int id, Chicken chicken) {
//        //intent to swap fragment and view single chicken detail\
//        chickensFragment = new ChickensFragment()Fragment();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(ARG_CHICKEN, chicken);
//        chickenDetailFragment.setArguments(bundle);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, chickenDetailFragment).commit();
//    }

}
