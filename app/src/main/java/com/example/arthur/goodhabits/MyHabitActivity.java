package com.example.arthur.goodhabits;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyHabitActivity extends AppCompatActivity {

    String mName = "";

    TextView mPrintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_habit);

        setSupportActionBar((Toolbar) findViewById(R.id.myhabit_toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mPrintView = (TextView) findViewById(R.id.myhabit_habit_value);

        findViewById(R.id.myhabit_save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameField = (EditText) findViewById(R.id.myhabit_healthy_habit_input);
                Editable nameEditable = nameField.getText();
                mName += nameEditable.toString()+'\n';
                mPrintView.setText(mName);
                nameField.setText("");
            }
        });

        findViewById(R.id.myhabit_finish_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameField = (EditText) findViewById(R.id.myhabit_healthy_habit_input);
                Editable nameEditable = nameField.getText();
                mName += nameEditable.toString()+'\n';
                Intent intent = new Intent(MyHabitActivity.this, Sec.class);
                intent.putExtra("data", mName);
                startActivity(intent);
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
