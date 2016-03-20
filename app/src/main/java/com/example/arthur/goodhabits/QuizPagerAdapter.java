package com.example.arthur.goodhabits;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v4.view.PagerAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Arthur on 3/17/2016.
 */
public class QuizPagerAdapter extends PagerAdapter {

    @IntDef(value = {POSITION_1, POSITION_2, POSITION_3, POSITION_4,
            POSITION_5, POSITION_6, POSITION_7, POSITION_8, POSITION_9, POSITION_10})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    public static final int POSITION_1 = 0;
    public static final int POSITION_2 = 1;
    public static final int POSITION_3 = 2;
    public static final int POSITION_4 = 3;
    public static final int POSITION_5 = 4;
    public static final int POSITION_6 = 5;
    public static final int POSITION_7 = 6;
    public static final int POSITION_8 = 7;
    public static final int POSITION_9 = 8;
    public static final int POSITION_10 = 9;

    public static final int NUMBER_OF_POSITIONS = 10;

    private LayoutInflater mLayoutInflater;

    private Context mContext;

    private EditText mAgeInput, mHeightInput, mWeightInput;

    private int mAge = -1, mHeight = -1, mWeight = -1;
    private int mSelected2 = -1, mSelected3 = -1, mSelected4 = -1, mSelected5 = -1,
            mSelected6 = -1, mSelected7 = -1, mSelected8 = -1, mSelected9 = -1, mSelected10 = -1;

    public QuizPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, @Position int position) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(container.getContext());
        }
        View view = null;
        switch (position) {
            case POSITION_1:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager_0, container, false);
                mAgeInput = ((EditText) view.findViewById(R.id.quiz_assessment_age_input));
                if (mAge > -1) mAgeInput.setText(String.valueOf(mAge));
                mAgeInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        mAge = Integer.parseInt(s.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                mHeightInput = ((EditText) view.findViewById(R.id.quiz_assessment_height_input));
                if (mHeight > -1) mHeightInput.setText(String.valueOf(mHeight));
                mHeightInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        mHeight = Integer.parseInt(s.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                mWeightInput = (EditText) view.findViewById(R.id.quiz_assessment_weight_input);
                if (mWeight > -1) mWeightInput.setText(String.valueOf(mWeight));
                mWeightInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        mWeight = Integer.parseInt(s.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                mWeightInput.setOnKeyListener(new View.OnKeyListener() {
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                            ((QuizActivity) mContext).setCurrentItem(POSITION_2);
                            return true;
                        }
                        return false;
                    }
                });
                break;
            case POSITION_2:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager_1, container, false);
                view.findViewById(R.id.quiz_view_pager_root);
                RadioGroup radioGroup_2 = (RadioGroup) view.findViewById(R.id.radioGroup_1);
                if (mSelected2 > -1) radioGroup_2.check(mSelected2);
                radioGroup_2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        mSelected2 = checkedId;
                        ((QuizActivity) mContext).setCurrentItem(POSITION_3);
                    }
                });
                break;
            case POSITION_3:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager_2, container, false);
                view.findViewById(R.id.quiz_view_pager_root);
                RadioGroup radioGroup_3 = (RadioGroup) view.findViewById(R.id.radioGroup_2);
                if (mSelected3 > -1) radioGroup_3.check(mSelected3);
                radioGroup_3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        mSelected3 = checkedId;
                        ((QuizActivity) mContext).setCurrentItem(POSITION_4);
                    }
                });
                break;
            case POSITION_4:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager_3, container, false);
                view.findViewById(R.id.quiz_view_pager_root);
                RadioGroup radioGroup_4 = (RadioGroup) view.findViewById(R.id.radioGroup_3);
                if (mSelected4 > -1) radioGroup_4.check(mSelected4);
                radioGroup_4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        mSelected4 = checkedId;
                        ((QuizActivity) mContext).setCurrentItem(POSITION_5);
                    }
                });
                break;
            case POSITION_5:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager_4, container, false);
                view.findViewById(R.id.quiz_view_pager_root);
                RadioGroup radioGroup_5 = (RadioGroup) view.findViewById(R.id.radioGroup_4);
                if (mSelected5 > -1) radioGroup_5.check(mSelected5);
                radioGroup_5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        mSelected5 = checkedId;
                        ((QuizActivity) mContext).setCurrentItem(POSITION_6);
                    }
                });
                break;
            case POSITION_6:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager_5, container, false);
                view.findViewById(R.id.quiz_view_pager_root);
                RadioGroup radioGroup_6 = (RadioGroup) view.findViewById(R.id.radioGroup_5);
                if (mSelected6 > -1) radioGroup_6.check(mSelected6);
                radioGroup_6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        mSelected6 = checkedId;
                        ((QuizActivity) mContext).setCurrentItem(POSITION_7);
                    }
                });
                break;
            case POSITION_7:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager_6, container, false);
                view.findViewById(R.id.quiz_view_pager_root);
                RadioGroup radioGroup_7 = (RadioGroup) view.findViewById(R.id.radioGroup_6);
                if (mSelected7 > -1) radioGroup_7.check(mSelected7);
                radioGroup_7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        mSelected7 = checkedId;
                        ((QuizActivity) mContext).setCurrentItem(POSITION_8);
                    }
                });
                break;
            case POSITION_8:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager_7, container, false);
                view.findViewById(R.id.quiz_view_pager_root);
                RadioGroup radioGroup_8 = (RadioGroup) view.findViewById(R.id.radioGroup_7);
                if (mSelected8 > -1) radioGroup_8.check(mSelected8);
                radioGroup_8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        mSelected8 = checkedId;
                        ((QuizActivity) mContext).setCurrentItem(POSITION_9);
                    }
                });
                break;

            case POSITION_9:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager_8, container, false);
                view.findViewById(R.id.quiz_view_pager_root);
                RadioGroup radioGroup_9 = (RadioGroup) view.findViewById(R.id.radioGroup_8);
                if (mSelected9 > -1) radioGroup_9.check(mSelected9);
                radioGroup_9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        mSelected9 = checkedId;
                        ((QuizActivity) mContext).setCurrentItem(POSITION_10);
                    }
                });
                break;
            case POSITION_10:
                view = mLayoutInflater.inflate(R.layout.quiz_view_pager_9, container, false);
                view.findViewById(R.id.quiz_view_pager_root);
                RadioGroup radioGroup_10 = (RadioGroup) view.findViewById(R.id.radioGroup_9);
                if (mSelected10 > -1) radioGroup_10.check(mSelected10);
                radioGroup_10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        mSelected10 = checkedId;
                    }
                });
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
