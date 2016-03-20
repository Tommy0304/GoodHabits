package com.example.arthur.goodhabits;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthur on 3/18/2016.
 */
public class HabitListAdapter extends BaseAdapter {

    private static final String TAG = "HabitListAdapter";

    List<Habit> mHabitList = new ArrayList<>();

    public HabitListAdapter() {

    }

    public HabitListAdapter(List<Habit> list) {
        mHabitList = list;
    }

    @Override
    public int getCount() {
        return mHabitList.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        CheckBox checkBox;
        TextView task;
        ImageButton removeButton;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_habit, parent, false);
            checkBox = ((CheckBox) convertView.findViewById(R.id.item_check_box));
            task = ((TextView) convertView.findViewById(R.id.item_task));
            removeButton = (ImageButton) convertView.findViewById(R.id.item_remove);

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("---------------", "onClick: " + position);
                    mHabitList.remove(position);
                    notifyDataSetChanged();
                }
            });

            convertView.setTag(new ViewHolder(checkBox, task, removeButton));

            Log.e(TAG, "getView:  ---   Inflate " + position + "   ---");
        } else {

            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            checkBox = viewHolder.checkBox;
            task = viewHolder.task ;
            removeButton = viewHolder.removeButton;

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("---------------", "onClick: " + (position));
                    mHabitList.remove(position);
                    notifyDataSetChanged();
                }
            });

            Log.e(TAG, "getView:  ---   ViewHolder " + position + "   ---");
        }

        Habit habit = getItem(position);
        checkBox.setChecked(habit.isChecked());
        task.setText(habit.getTask());

        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Habit getItem(int position) {
        return mHabitList.get(position);
    }

    public void addHabit(Habit habit) {
        mHabitList.add(habit);
        notifyDataSetChanged();
    }

    public void addHabit(List<Habit> list) {
        mHabitList.addAll(list);
        notifyDataSetChanged();
    }

    private class ViewHolder {
        public final CheckBox checkBox;
        public final TextView task;
        public final ImageButton removeButton;

        public ViewHolder(CheckBox checkBox, TextView task, ImageButton removeButton) {
            this.checkBox = checkBox;
            this.task = task;
            this.removeButton = removeButton;
        }
    }
}
