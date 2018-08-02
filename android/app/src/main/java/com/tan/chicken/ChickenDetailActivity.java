package com.tan.chicken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.tan.chicken.domain.Chicken;

public class ChickenDetailActivity extends AppCompatActivity {

    private TextView name, pedigree, gender, weight;

    private static final String ARG_CHICKEN = "CHICKEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_detail);

        name = findViewById(R.id.name);
        pedigree = findViewById(R.id.pedigree);
        gender = findViewById(R.id.gender);
        weight = findViewById(R.id.weight);

        initValues();
    }

    private void initValues(){
        Chicken chicken = (Chicken) getIntent().getSerializableExtra(ARG_CHICKEN);
        name.setText(chicken.getName());
        pedigree.setText(chicken.getPedigree());
        gender.setText(chicken.getGender());
        weight.setText(chicken.getWeight().toString());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
