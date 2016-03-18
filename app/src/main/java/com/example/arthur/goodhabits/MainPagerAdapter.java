package com.example.arthur.goodhabits;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Arthur on 3/17/2016.
 */
public class MainPagerAdapter extends PagerAdapter {

    @IntDef(value = {POSITION_1, POSITION_2, POSITION_3})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    public static final int POSITION_1 = 0;
    public static final int POSITION_2 = 1;
    public static final int POSITION_3 = 2;
    public static final int NUMBER_OF_POSITIONS = 3;

    private Context mContext;

    public MainPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view;

        if (position == POSITION_2) {
            view = new ImageView(mContext);
            ((ImageView)view).setImageResource(R.drawable.swiper);
        } else {
            view = new View(mContext);
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