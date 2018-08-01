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

public class DashboardActivity extends AppCompatActivity implements ChickenFragment.OnListFragmentInteractionListener{


    private static final String ARG_CHICKEN = "CHICKEN";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
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

        ChickenFragment chickenFragment = new ChickenFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, chickenFragment).commit();
    }

    @Override
    public void onChickenClick(int id, Chicken chicken) {
        //intent to swap fragment and view single chicken detail\
        ChickenDetailFragment chickenDetailFragment = new ChickenDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_CHICKEN, chicken);
        chickenDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, chickenDetailFragment).commit();
    }
}
