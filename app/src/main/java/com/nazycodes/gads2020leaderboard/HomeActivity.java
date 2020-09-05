package com.nazycodes.gads2020leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.nazycodes.gads2020leaderboard.adapters.TabAdapter;

public class HomeActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabAdapter mTabAdapter;
    private TabLayout mTabLayout;
    private TextView txtSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtSubmit = findViewById(R.id.txtSubmit);

        txtSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SubmissionActivity.class);
                startActivity(intent);
            }
        });

        setViewPager();
    }

    private void setViewPager() {

        mViewPager = findViewById(R.id.viewPager);
        mTabAdapter = new TabAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mTabAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tabBar);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}