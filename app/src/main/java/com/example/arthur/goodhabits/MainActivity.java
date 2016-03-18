package com.example.arthur.goodhabits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class MainActivity extends AppCompatActivity/* implements SimpleGestureFilter.SimpleGestureListener*/ {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.main_toolbar));

        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        mViewPager.setAdapter(new MainPagerAdapter(this));
//        mViewPager.setCurrentItem(1);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(@MainPagerAdapter.Position int position) {
                Log.e("------------------", "onPageSelected: " + position);
                if (position == MainPagerAdapter.POSITION_1){
                    startActivity(new Intent(MainActivity.this, QuizActivity.class));
                }else if (position == MainPagerAdapter.POSITION_3){
                    startActivity(new Intent(MainActivity.this, MyHabitActivity.class));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewPager.setCurrentItem(1);
    }
}
