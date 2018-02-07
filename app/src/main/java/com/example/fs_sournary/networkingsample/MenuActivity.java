package com.example.fs_sournary.networkingsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.fs_sournary.networkingsample.sample1.MainActivity;
import com.example.fs_sournary.networkingsample.sample2.LoaderActivity;
import com.example.fs_sournary.networkingsample.sample3.screen.EarthquakeActivity;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findViewById(R.id.button_sample_1).setOnClickListener(this);
        findViewById(R.id.button_sample_2).setOnClickListener(this);
        findViewById(R.id.button_sample_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_sample_1:
                startActivity(MainActivity.newInstance(MenuActivity.this));
                break;
            case R.id.button_sample_2:
                startActivity(LoaderActivity.newInstance(MenuActivity.this));
                break;
            case R.id.button_sample_3:
                startActivity(EarthquakeActivity.newInstance(MenuActivity.this));
                break;
            default:
                break;
        }
    }
}
