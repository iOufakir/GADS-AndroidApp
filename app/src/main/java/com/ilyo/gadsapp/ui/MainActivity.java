package com.ilyo.gadsapp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ilyo.gadsapp.R;
import com.ilyo.gadsapp.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        // Toolbar
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Submit button
        MaterialButton submitBtn = findViewById(R.id.toolbar_submit_button);
        submitBtn.setOnClickListener(view -> submitActivity());

        // Viewpager
        ViewPager2 viewPager = findViewById(R.id.leaderboard_pager);
        viewPager.setAdapter(new ViewPagerAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tabs);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) {
                        tab.setText("Learning Leaders");
                    } else {
                        tab.setText("Skill IQ Leaders");
                    }
                }).attach();
    }

    private void submitActivity() {
        Intent intent = new Intent(MainActivity.this, SubmissionActivity.class);
        startActivity(intent);
    }

}