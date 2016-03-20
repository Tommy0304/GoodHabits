package com.example.arthur.goodhabits;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ViewSwitcher;

import com.viewpagerindicator.CirclePageIndicator;

public class QuizActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        initViews();

    }

    private void initViews(){
        setSupportActionBar((Toolbar) findViewById(R.id.quiz_toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mViewPager = (ViewPager) findViewById(R.id.quiz_viewpager);
        final QuizPagerAdapter quizPagerAdapter = new QuizPagerAdapter(this);
        mViewPager.setAdapter(quizPagerAdapter);

        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.quiz_view_pager_indicator);
        indicator.setViewPager(mViewPager);
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(@QuizPagerAdapter.Position int position) {
                Log.e("------------------", "onPageSelected: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void setCurrentItem(int index) {
        mViewPager.setCurrentItem(index);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
