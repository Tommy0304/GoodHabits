package com.example.arthur.goodhabits;

import android.graphics.Color;
import android.support.annotation.IntDef;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Arthur on 3/17/2016.
 */
public class QuizPagerAdapter extends PagerAdapter {

    @IntDef(value = {POSITION_1, POSITION_2})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    public static final int POSITION_1 = 0;
    public static final int POSITION_2 = 1;
    public static final int POSITION_3 = 2;
    public static final int NUMBER_OF_POSITIONS = 3;

    private LayoutInflater mLayoutInflater;

    public QuizPagerAdapter() {
    }

    @Override
    public Object instantiateItem(ViewGroup container, @Position int position) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(container.getContext());
        }
        View view = null;
        switch (position) {
            case POSITION_1:
                view = mLayoutInflater.inflate(R.layout.quiz_assessment_page, container, false);
                break;
            case POSITION_2:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager, container, false);
                view.findViewById(R.id.quiz_view_pager_root).setBackgroundColor(Color.RED);
                break;
            case POSITION_3:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager, container, false);
                view.findViewById(R.id.quiz_view_pager_root).setBackgroundColor(Color.YELLOW);
                break;
        }

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return NUMBER_OF_POSITIONS;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }
}
