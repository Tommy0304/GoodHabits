package com.example.arthur.goodhabits;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;

public class MyHabitActivity extends AppCompatActivity {

    private static final String TAG = "MyHabitActivity";

    String mName = "";

    ViewGroup mHabitManageerContainer;
    EditText mTaskInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_habit);

        setSupportActionBar((Toolbar) findViewById(R.id.myhabit_toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mHabitManageerContainer = (ViewGroup) findViewById(R.id.myhabit_habit_view_group);
        mTaskInput = (EditText) findViewById(R.id.myhabit_healthy_habit_input);

        final CalendarView calendarView = (CalendarView) findViewById(R.id.myhabit_calendar);
        if (calendarView != null) {
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                    Log.e(TAG, "onSelectedDayChange: " + year + " / " + month + " / " + dayOfMonth);
                    mHabitManageerContainer.setVisibility(View.VISIBLE);
                    calendarView.setVisibility(View.GONE);
                }
            });
        }

        ListView listView = (ListView) findViewById(R.id.myhabit_habit_list);
        final HabitListAdapter habitListAdapter = new HabitListAdapter();
        listView.setAdapter(habitListAdapter);

        findViewById(R.id.myhabit_add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mName += mTaskInput.getText().toString()+'\n';
                habitListAdapter.addHabit(new Habit(mTaskInput.getText().toString(), false));
                mTaskInput.setText("");
            }
        });

        findViewById(R.id.myhabit_done_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHabitManageerContainer.setVisibility(View.GONE);
                calendarView.setVisibility(View.VISIBLE);
            }
        });
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
